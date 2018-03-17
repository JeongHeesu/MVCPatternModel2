package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.net.httpserver.Filter.Chain;
/**
 * @Class Name : Filter2.java
 * @Description : 필터 사용2
 * @Modification Information
 * @author 정희수
 * @since  2018.03.14.
 * @version 1.0
 * @see Filter
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.14.  정희수      최초작성
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
public class Filter2 implements Filter {

	@Override
	public void destroy() {
		//필터가 인스턴스화 된 이후 해당 필터의 GC되기 직전에 콜백
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//전처리(빨간색)
		System.out.println("Filter2 전처리");
		chain.doFilter(req,res);
		
		//후처리
		System.out.println("Filter2 후처리");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//필터가 인스턴스화 된 직후 콜백
	}

}
