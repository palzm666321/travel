package cn.mldn.util.action.abs;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.context.MessageSource;

public abstract class AbstractBaseAction {
	@Resource
	private MessageSource messageSource;
	
	public String getEid() {
		return SecurityUtils.getSubject().getPrincipals().toString();
	}
	
	public void setUrlAndMsg(HttpServletRequest request ,String urlKey,String msgKey,Object...arg) {
		request.setAttribute("msg", this.getMsg(msgKey, arg));
		request.setAttribute("url", this.getMsg(urlKey));
	}
	
	public void print(HttpServletResponse response ,Object val) {
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(val);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl(String key) {
		return this.getMsg(key) ;
	}
	
	public String getMsg(String key, Object... args) {
		try {
			return this.messageSource.getMessage(key, args, null);
		} catch (Exception e) {
			return null;
		}
	}

	public Set<String> handleStringIds(String ids) {
		Set<String> set = new HashSet<String>() ;
		String result [] = ids.split(",") ;
		for (int x = 0 ; x < result.length ; x ++) {
			set.add(result[x]) ;
		}
		return set ;
	}
}
