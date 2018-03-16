package kr.or.ddit.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.base.controller.action.IAction;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
/**
 * @Class Name : MemberListAction.java
 * @Description :  memberList.do 접근
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
public class MemberListAction implements IAction {
	private boolean redirectFlag = false;
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		IMemberService service = IMemberServiceImpl.getInstance();
		List<MemberVO> memberList = service.getMemberList();
		
		HttpSession session = request.getSession();
		
		request.setAttribute("memberList", memberList);
		
		return "/WEB-INF/member/memberList.jsp";
	}

}
