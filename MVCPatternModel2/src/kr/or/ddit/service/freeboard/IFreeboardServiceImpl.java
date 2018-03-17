package kr.or.ddit.service.freeboard;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.freeboard.IFreeboardDao;
import kr.or.ddit.dao.freeboard.IFreeboardDaoImpl;
import kr.or.ddit.utils.AttachFileMapper;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeboardVO;

import org.apache.commons.fileupload.FileItem;

/**
 * @Class Name : IFreeboardServiceImpl.java
 * @Description : Dao 연결
 * @Modification Information
 * @author 정희수
 * @since  2018.03.09.
 * @version 1.0
 * @see IFreeboardService
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.09.  정희수      최초작성
 *    2018.03.12.  정희수      insert,view
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
public class IFreeboardServiceImpl implements IFreeboardService {
	private static IFreeboardService service = new IFreeboardServiceImpl();
//	private IFileItemDao fileItemDao;
	private static IFreeboardDao dao;
	
	private IFreeboardServiceImpl(){
		dao = IFreeboardDaoImpl.getInstance();
//		fileItemDao = IFileItemDaoImpl.getInstance();
	}
	
	public static IFreeboardService getInstance(){
		return (service == null) ? service = new IFreeboardServiceImpl() : service;
	}
	
	@Override
	public FreeboardVO getFreeboardInfo(Map<String, String> params) {
		FreeboardVO freeboardInfo = null;
		
		try {
			freeboardInfo = dao.getFreeboardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return freeboardInfo;
	}

	/**
	 * 게시판 목록
	 */
	@Override
	public List<FreeboardVO> getFreeboardList(Map<String, String> params) {
		List<FreeboardVO> freeboardList = null;
		try {
			freeboardList = dao.getFreeboardList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeboardList;
	}
	/**
	 * 게시글 등록
	 */
	@Override
	public String insertFreeboardInfo(FreeboardVO freeboardInfo, FileItem[] items) {
		String bo_no = null;
		
		try {
			bo_no = dao.insertFreeboardInfo(freeboardInfo);
			List<FileItemVO> fileItemList = AttachFileMapper.mapping(bo_no,items);
//			fileItemDao.insertFileItemInfo(fileItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bo_no;
	}
	/**
	 * 댓글 등록
	 */
	@Override
	public String insertFreeboardReplyInfo(FreeboardVO freeboardInfo) {
		String bo_no = null;
		try {
			bo_no = dao.insertFreeboardReplyInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bo_no;
	}

	/**
	 * 게시글 수정
	 */
	@Override
	public void updateFreeboardInfo(FreeboardVO freeboardInfo) {
		try {
			dao.updateFreeboardInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시글 비활성화(삭제)
	 */
	@Override
	public void deleteFreeboardInfo(Map<String, String> params) {
		try {
			dao.deleteFreeboardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  게시글의 총 개수 
	 */
	@Override
	public int getTotalCount(Map<String, String> params) {
		int totalCount = 0;
		try {
			totalCount = dao.getTotalCount( params);
		} catch (SQLException e) {
		}
		return totalCount;
	}

	@Override
	public List<FreeboardVO> getTestList() {
		List<FreeboardVO> testList = null;
		try {
			testList = dao.getTestList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public String insertFreeboardInfo2(FreeboardVO freeboardInfo) {
		String bo_no = null;
		
		try {
			bo_no = dao.insertFreeboardInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bo_no;
	}
}
