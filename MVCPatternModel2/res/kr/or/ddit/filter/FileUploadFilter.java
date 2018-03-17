package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.utils.FileUploadRequestWrapper;

import org.apache.commons.lang.StringUtils;
/**
 * @Class Name : FileUploadFilter.java
 * @Description : 파일 업로드 필터
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
public class FileUploadFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//일반요청 : 공백(location.href or loaction.replace() or <a href="">
		// 				브라우저 주소창에 직접  URL 입력)
//						<form> submitt 전송 -  apllication/x-www-form-urlencoded
		// 파일업로드 요청 : <form method=post enctype=mulipart/form-data>
		//				  ajax contentType:multipart/form-data
		
		
//		String contentType = req.getContentType();
		
//		if(StringUtils.isNotEmpty(contentType)&&contentType.toLowerCase().contains("multipart")){
		
			FileUploadRequestWrapper wrapper = new FileUploadRequestWrapper((HttpServletRequest)req);
			chain.doFilter(wrapper, res);
			
//		}else{
//			chain.doFilter(req, res);
//		}
			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
