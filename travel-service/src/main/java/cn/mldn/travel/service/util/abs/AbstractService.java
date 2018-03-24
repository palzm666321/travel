package cn.mldn.travel.service.util.abs;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractService {
	
	public Map<String,Object> handleParam(long currentPage,int lineSize,String column,String keyWord){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", (currentPage-1)*lineSize);
		map.put("lineSize", lineSize);
		if("".equals(keyWord)||"null".equals(keyWord)||keyWord==null) {
			map.put("keyWord", null);
		}else{
			map.put("keyWord", "%"+keyWord+"%");
		}
		if("".equals(column)||"null".equals(column)||column==null) {
			map.put("column", null);
		}else {
			map.put("column", column);
		}
		return map;
	}
	
}
