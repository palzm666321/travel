package cn.mldn.travel.action.back;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/travelaudit/*")
public class TravelAuditActionBack extends AbstractBaseAction {
	private static final String FLAG = "出差审核";
	
	@RequestMapping("list")
	@RequiresUser
	@RequiresRoles(value = { "travelaudit" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travelaudit:list" }, logical = Logical.OR)
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("travelaudit.list.page"));
		return mav;
	}
	
	@RequestMapping("prepare")
	@RequiresUser
	@RequiresRoles(value = { "travelaudit" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travelaudit:list" }, logical = Logical.OR)
	public ModelAndView prepare(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("travelaudit.prepare.page"));
		return mav;
	}
	
	@RequestMapping("handle_pre")
	@RequiresUser
	@RequiresRoles(value = { "travelaudit" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travelaudit:handle" }, logical = Logical.OR)
	public ModelAndView handlePre() {
		ModelAndView mav = new ModelAndView(super.getUrl("travelaudit.handle.page"));
		return mav;
	}
	 
	@RequestMapping("handle")
	@RequiresUser
	@RequiresRoles(value = { "travelaudit" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travelaudit:handle" }, logical = Logical.OR)
	public ModelAndView handle(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "travelaudit.prepare.action", "travelaudit.handle.failure",
		// FLAG);
		super.setUrlAndMsg(request, "travelaudit.prepare.action", "travelaudit.handle.success");
		return mav;
	}
}
