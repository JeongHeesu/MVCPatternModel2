package kr.or.ddit.service.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeboardVO;
/**
 * @Class Name : IFreeboardService.java
 * @Description : Dao 연결
 * @Modification Information
 * @author 정희수
 * @since  2018.03.09.
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.09.  정희수      최초작성
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
public interface IFreeboardService {
	/**
	 * 선택된게시판 내용 가져오기
	 * @param params
	 * @return FreeboardVO
	 */
	public  FreeboardVO getFreeboardInfo(Map<String, String>params);
	
	/**
	 * 게시판리스트 가져오기
	 * @return List<FreeboardVO>
	 */
	public List<FreeboardVO> getFreeboardList(Map<String, String> params);
	
	/**
	 * 게시글 등록
	 * @param freeboardInfo
	 * @return String
	 */
	public String insertFreeboardInfo(FreeboardVO freeboardInfo, FileItem[] items);
	public String insertFreeboardInfo2(FreeboardVO freeboardInfo);
	
	/**
	 * 댓글
	 * @param freeboardInfo
	 * @return
	 */
	public String insertFreeboardReplyInfo(FreeboardVO freeboardInfo);
	/**
	 * 게시글 수정
	 * @param freeboardInfo
	 */
	public void updateFreeboardInfo(FreeboardVO freeboardInfo);
	
	/**
	 * 게시글 삭제
	 * @param params
	 */
	public void deleteFreeboardInfo(Map<String, String> params);
	
	/**
	 * 개시글 개수
	 * @param params
	 * @return
	 */
	public int getTotalCount(Map<String, String> params);
	
	public List<FreeboardVO> getTestList();
}	
