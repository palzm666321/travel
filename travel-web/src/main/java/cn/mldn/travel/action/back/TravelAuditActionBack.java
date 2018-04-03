package cn.mldn.travel.action.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.travel.service.back.ITravelServiceBack;
import cn.mldn.util.action.abs.AbstractBaseAction;
import cn.mldn.util.split.ActionSplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/travelaudit/*")
public class TravelAuditActionBack extends AbstractBaseAction {
	private static final String FLAG = "出差审核";
	@Resource
	private ITravelServiceBack travelServiceBack;
	
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
		ActionSplitPageUtil aspu=new ActionSplitPageUtil(request, "申请标题:title", super.getUrl("travelaudit.prepare.page"));
		System.err.println(this.travelServiceBack.listPrepare(aspu.getCurrentPage(), aspu.getLineSize(), aspu.getColumn(),aspu.getKeyWord()));
		mav.addAllObjects(this.travelServiceBack.listPrepare(aspu.getCurrentPage(), aspu.getLineSize(), aspu.getColumn(),aspu.getKeyWord()));
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
