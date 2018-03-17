package kr.or.ddit.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
/**
 * @Class Name : IPCheckFilter.java
 * @Description : 아이디 체크 필터
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
public class IPCheckFilter implements Filter {
	private static Map<String, String> ipMap;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		String clientIPAddr = req.getRemoteAddr();
		boolean flag = false;
		if(StringUtils.isNotEmpty(clientIPAddr) && ipMap.containsKey(clientIPAddr)){
			if("F".intern() == ipMap.get(clientIPAddr).intern()){
				flag = true;
			}
		}else{
			flag = true;
		}
		if(flag){
		    HttpServletResponse response = (HttpServletResponse)res;
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;  charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("<html>");
		    out.println("<body>");
		    out.println("<font color='blue' size='15'>인가된 클라이언트가 아닙니다.</font>");
		    out.println("</body>");
		    out.println("</html>");
		}else{
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ipMap = new HashMap<String, String>();
		ipMap.put("127.0.0.1", "A");
		ipMap.put("0:0:0:0:0:0:0:1", "A");
		ipMap.put("192.168.203.155", "A");
		ipMap.put("192.168.203.79", "F");
	}

}
