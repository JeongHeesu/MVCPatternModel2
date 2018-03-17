package kr.or.ddit.freeboard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.controller.action.IAction;
import kr.or.ddit.base.controller.handler.URIHandlerAdapter;
import kr.or.ddit.service.freeboard.IFreeboardService;
import kr.or.ddit.service.freeboard.IFreeboardServiceImpl;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardListAction implements IAction {
	private boolean redirectFalg = false;
	@Override
	public boolean isRedirect() {
		return redirectFalg;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		IFreeboardService service = IFreeboardServiceImpl.getInstance();

		String currentPage = request.getParameter("currentPage");
		if(currentPage == null){
			currentPage = "1";
		}
	
		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		int totalCount = service.getTotalCount(params);
		
		RolePagingUtil pageUtil = new RolePagingUtil(Integer.parseInt(currentPage), totalCount,request);
		
		String startCount =String.valueOf(pageUtil.getStartCount());
		String endCount = String.valueOf(pageUtil.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		String pagingContent = pageUtil.getPageHtmls().toString();
		
		List<FreeboardVO> freeboardList = service.getFreeboardList(params);
//		List<FreeboardVO> testList = service.getTestList();
		
		request.setAttribute("testList", freeboardList);
//		request.setAttribuste("testList", testList);
		//포워딩처리
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		dispatcher.forward(request, response);
		
		return "/user/freeboard/freeboardList.tiles";
	}

}
