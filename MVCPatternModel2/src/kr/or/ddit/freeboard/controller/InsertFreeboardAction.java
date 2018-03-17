package kr.or.ddit.freeboard.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.base.controller.action.IAction;
import kr.or.ddit.service.freeboard.IFreeboardService;
import kr.or.ddit.service.freeboard.IFreeboardServiceImpl;
import kr.or.ddit.utils.FileUploadRequestWrapper;
import kr.or.ddit.vo.FreeboardVO;

import org.apache.commons.beanutils.BeanUtils;

public class InsertFreeboardAction implements IAction {
	private boolean redirectFlag = false;
	@Override
	public boolean isRedirect() {
		return redirectFlag;
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
		
//		FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper)request;

		FreeboardVO freeboardInfo = new FreeboardVO();
		
		try {
//			BeanUtils.populate(freeboardInfo, wrapper.getParameterMap());
			BeanUtils.populate(freeboardInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IFreeboardService service = IFreeboardServiceImpl.getInstance();
//		service.insertFreeboardInfo(freeboardInfo, wrapper.getFileitemValues("files"));
		service.insertFreeboardInfo2(freeboardInfo);
		
		
		
		return "/main.do";
	}

}
