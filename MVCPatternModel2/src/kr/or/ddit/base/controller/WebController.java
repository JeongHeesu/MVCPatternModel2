package kr.or.ddit.base.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.controller.action.IAction;
import kr.or.ddit.base.controller.handler.URIHandlerAdapter;

import org.apache.catalina.connector.Request;
/**
 * @Class Name : WebController.java
 * @Description :  do 파일 접근을 위한 filter 컨트롤러
 * @Modification Information
 * @author 정희수
 * @since  2018.03.14.
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.15.  정희수       최초작성
 *    2018.03.16.  정희수       작성완료
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
public class WebController extends HttpServlet {

	//클라이언트가 확장자 do 로 메서트 post || get 상관없이 요청 취득
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 컨텍스트루트 |패스 : /
		//				   : /ddit
		String requestURI = request.getRequestURI();
		requestURI = requestURI.substring(request.getContextPath().length());
		
		// URI : /ddit/member/memberForm.do
		//ServletPaht : /member/memberForm.do
		//컨트롤러 요청시의 servlet path를 기준으로 
		//IAction : Interface
		IAction action = URIHandlerAdapter.getAction(requestURI);
		
		if(action != null){
			String view = action.process(request, response);
			//view == null  : 파일다운로드
			//					response를 코드로 직접 셋팅
			//				: ajax요청에 대한 응답
			//					response 출력버퍼에 PrintWriter로 저장 후 전송
			if(view != null){
				// view =! null  : /member/memberList.jsp
				//				   /member/memberList.do
				if(action.isRedirect()){
					response.sendRedirect(request.getContextPath()+view);
				}else{
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				}
			}
		}else{
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		
	}//메소드 긋
	
}
