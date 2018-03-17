package kr.or.ddit.dao.freeboard;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeboardVO;

/**
 * @Class Name : IFreeboardDao.java
 * @Description : Dao 쿼리질의
 * @Modification Information
 * @author 정희수
 * @since  2018.03.09.
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.09.  정희수      최초작성
 *    2018.03.15.  정희수      개시글 수
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */

public interface IFreeboardDao {
	/**
	 * 선택된게시판 내용 가져오기
	 * @param params
	 * @throws SQLException
	 * @return FreeboardVO
	 */
	public  FreeboardVO getFreeboardInfo(Map<String, String>params) throws SQLException;
	
	public String insertFreeboardInfo2(FreeboardVO freeboardInfo) throws SQLException;
	
	/**
	 * 게시판리스트 가져오기
	  * @throws SQLException
	 * @return List<FreeboardVO>
	 */
	public List<FreeboardVO> getFreeboardList(Map<String, String> params)throws SQLException;
	
	/**
	 * 게시글 등록
	 * @param freeboardInfo
	 * @throws SQLException
	 * @return String
	 */
	public String insertFreeboardInfo(FreeboardVO freeboardInfo)throws SQLException;
	
	/**
	 * 댓글
	 * @param freeboardInfo
	 * @return
	 * @throws SQLException
	 */
	public String insertFreeboardReplyInfo(FreeboardVO freeboardInfo)throws SQLException;
	
	/**
	 * 게시글 수정
	 * @throws SQLException
	 * @param freeboardInfo
	 */
	public void updateFreeboardInfo(FreeboardVO freeboardInfo)throws SQLException;
	
	/**
	 * 게시글 삭제
	 * @throws SQLException
	 * @param params
	 */
	public void deleteFreeboardInfo(Map<String, String> params)throws SQLException;
	
	/**
	 * 게시글 개수
	 * @param params
	 * @return Integer
	 * @throws SQLException
	 */
	public int getTotalCount(Map<String, String> params) throws SQLException;
	
	public List<FreeboardVO> getTestList() throws SQLException;
}
