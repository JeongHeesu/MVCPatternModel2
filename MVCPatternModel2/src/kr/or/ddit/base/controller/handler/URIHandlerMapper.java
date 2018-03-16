package kr.or.ddit.base.controller.handler;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
/**
 * @Class Name : URIHandlerMapper.java
 * @Description :  porperties파일 연결
 * @Modification Information
 * @author 정희수
 * @since  2018.03.14.
 * @version 1.0
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2018.03.15.  정희수       최초작성
 *    2018.03.16.  정희수       작성완료
 * Copyright (c) 2018 by DDIT  All right reserved
 * </pre>
 */
public class URIHandlerMapper {
	private static Map<String, String> actionMap = new HashMap<String, String>();
	
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.base.controller.props.requestURIMapper");
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String value =bundle.getString(key);
			actionMap.put(key, value);
		}
	}
	
	
	public static Map<String, String> getActionMap() {
		return actionMap;
	}
	
}
