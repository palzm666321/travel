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
@RequestMapping("/pages/back/admin/travel/*")
public class TravelActionBack extends AbstractBaseAction {
	private static final String FLAG = "出差申请";
	@RequestMapping("add_pre")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:add" }, logical = Logical.OR)
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.add.page"));
		return mav;
	}

	@RequestMapping("add")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:add" }, logical = Logical.OR)
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "travel.add.action", "vo.add.failure",
		// FLAG);
		super.setUrlAndMsg(request, "travel.add.action", "vo.add.success", FLAG);
		return mav;
	}
	
	@RequestMapping("list_emp")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:self" }, logical = Logical.OR)
	public ModelAndView listEmp(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.emp.page"));
		return mav;
	}
	
	@RequestMapping("list_self")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:self" }, logical = Logical.OR)
	public ModelAndView listSelf(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.self.page"));
		return mav;
	}
	
	@RequestMapping("user_edit_pre")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:edit" }, logical = Logical.OR)
	public ModelAndView editUser() {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.user.page"));
		return mav;
	}

	@RequestMapping("cost_edit_pre")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:edit" }, logical = Logical.OR)
	public ModelAndView editCost() {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.cost.page"));
		return mav;
	}
	
	
	
	@RequestMapping("edit_pre")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:edit" }, logical = Logical.OR)
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.edit.page"));
		return mav;
	}
	 
	@RequestMapping("edit")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:edit" }, logical = Logical.OR)
	public ModelAndView edit(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "travel.self.action", "vo.edit.failure",
		// FLAG);
		super.setUrlAndMsg(request, "travel.self.action", "vo.edit.success", FLAG);
		return mav;
	}
	
	@RequestMapping("delete")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:delete" }, logical = Logical.OR)
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "travel.self.action", "vo.delete.failure",
		// FLAG);
		super.setUrlAndMsg(request, "travel.self.action", "vo.delete.success", FLAG);
		return mav;
	}
	
	@RequestMapping("submit")
	@RequiresUser
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:submit" }, logical = Logical.OR)
	public ModelAndView submit(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "travel.self.action", "travel.submit.failure");
		super.setUrlAndMsg(request, "travel.self.action", "travel.submit.success");
		return mav;
	}
}
