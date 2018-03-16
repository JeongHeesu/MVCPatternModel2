package kr.or.ddit.freeboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.controller.action.IAction;

public class FreeboardListAction implements IAction {
	private boolean redirectFalg = false;
	@Override
	public boolean isRedirect() {
		return redirectFalg;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		//ifreeboardService service = IfreeboardServiceImpl.getInstance();
		//List<freeboardVO> freeboardList = service.getFreebaordList();
		//request.setAttribute("freeboardList", freeboardList);
		//포워딩처리
		
		return null;
	}

}
