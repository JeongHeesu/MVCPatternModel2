package kr.or.ddit.base.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Class Name : IAction.java
 * @Description :  모델레이어 접근
 * @Modification Information
 * @author 정희수
 * @since  2018.03.14.
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.15.  정희수       최초작성
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
//모든 Servant 클래스(액션클래스)는 반드시 IAction 인터페이스를 구현.
public interface IAction {
	// 액션클래스 : 모델 레이어(Service Layer, Dao Layer, VO) 접근
	//			  View(jsp) 결정
	//			   해당 View로 리다이렉트, 기타 포워딩 처리 결정
	public boolean isRedirect();
	
	public String process(HttpServletRequest request, HttpServletResponse response);
}
