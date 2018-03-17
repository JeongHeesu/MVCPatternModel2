package kr.or.ddit.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.controller.action.IAction;
/**
 * @Class Name : MainAction.java
 * @Description :  main.do 접근
 * @Modification Information
 * @author 정희수
 * @since  2018.03.14.
 * @see IAction
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.16.  정희수      최초작성
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
public class MainAction implements IAction {
	//기본적으로 포워딩 처리
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		//모델 레이어 접근, jsp(view-포워딩) or .do(리닫이렉트)로 포워딩 또는 리다이렉트
		// view 반환
//		return "/WEB-INF/index.jsp";
		
		return "/user/freeboard/freeboardList.do";
	}

}
