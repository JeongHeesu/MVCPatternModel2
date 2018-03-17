package kr.or.ddit.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;
/**
 * @Class Name : LoginCheckFilter.java
 * @Description : 로그인 체크 필터
 * @Modification Information
 * @author 정희수
 * @since  2018.03.15.
 * @version 1.0
 * @see Filter
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.15.  정희수      최초작성
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//로그인 하면 세션에 LOGIN_MEMBERINFO로 회원정보(MemberVO) 저장
		HttpServletRequest requset = (HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)res;
		//getSEssion() -> 현재 해당 클라이언트와 맵핑된 세션을 취득,
		//getSession(true or false) 
		//			true : 현재 해당 클라이언트와 맴핑된 세션을 취득
		//					해당 클라이언트와 맴핑된 세션이 존재하지 않을때 신규 세션 생성취득.
		//			false :  새로운 해당 클라이언트와 맵핑된 세션을 취득
		//				     해당 클라이언트와 맵핑된 세션이 존재핮 ㅣ않을때 익셉션 발생
		
		HttpSession session = requset.getSession();
		MemberVO memberInfo = (MemberVO) session.getAttribute("LOGIN_MEMBERINFO");
		if(memberInfo != null){
			chain.doFilter(req, res);
		}else{
			String message = URLEncoder.encode("로그인해주세요.","UTF-8");
			response.sendRedirect(requset.getContextPath()+"/11/loginForm.jsp?message="+message);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
