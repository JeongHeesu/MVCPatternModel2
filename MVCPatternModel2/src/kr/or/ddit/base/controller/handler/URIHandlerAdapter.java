package kr.or.ddit.base.controller.handler;

import java.util.Map;

import kr.or.ddit.base.controller.action.IAction;

/**
 * @Class Name : URIHandlerAdapter.java
 * @Description :  URI접근 위한 연결
 * @Modification Information
 * @author 정희수
 * @since  2018.03.14.
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.15.  정희수       최초작성
 *    2018.03.16.  정희수      작성완료
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
//클라이언트----------------?.do --------------------------->WebController(Servlet)
//														 	요청취득
//															ServletPaht(컨텍스트루트|패스 배제된 주소)\
//															action =URIHandlerAdapter.getAction(ServletPaht)
//																		URIHanadalerMapper.getActionMap()
//																			Map<ServletPath, 액션클래스경로>
//																				requestURIMapper.properties
//																					/member/memberList.do=kr.or....memberListAction

//컨트롤러로 부터 취득한 서블렛path를 기준으로 해당 요청을 처리할 액션클래스의 인스턴스(동적 인스턴스화)를 반환
//액션클래스의 인스턴스(동적 인스턴스화를 반환)
public class URIHandlerAdapter {
	// URIHandlerMapper => properties파일 접근
	//						/member/memberList.do = kr.or.ddit.member.controller.MemberListAction	
	//						/member/memberView.do = kr.or.ddit.member.controller.MemberViewAction	
	
	// 해당 요청을 처리한 액션클래스를 선택
	//(/member/memberList.do = kr.or.ddit.member.controller.MemberListAction)
	public static IAction getAction(String requestURI){
		//URIHandlerMapper =>properties 파일 접근
							// /member~~~
		
		Map<String, String> actionMap = URIHandlerMapper.getActionMap();
		IAction action =null;
		
		if(actionMap.containsKey(requestURI)){
			Class clazz;
			try {
				clazz = Class.forName(actionMap.get(requestURI));
				action = (IAction) clazz.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return action;
	}
	
}
