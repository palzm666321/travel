package cn.mldn.travel.action.back;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Item;
import cn.mldn.travel.vo.Level;
import cn.mldn.travel.vo.Type;
import cn.mldn.util.ListToMapUtils;
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
		mav.addAllObjects(this.travelServiceBack.listPrepare(aspu.getCurrentPage(), aspu.getLineSize(), aspu.getColumn(),aspu.getKeyWord()));
		return mav;
	}
	
	@RequestMapping("handle_pre")
	@RequiresUser
	@RequiresRoles(value = { "travelaudit" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travelaudit:handle" }, logical = Logical.OR)
	public ModelAndView handlePre(long tid) {
		ModelAndView mav = new ModelAndView(super.getUrl("travelaudit.handle.page"));
		Map<String,Object> map=this.travelServiceBack.getDetailsAudit(tid);
		mav.addAllObjects(map);
		mav.addObject("allDepts", new ListToMapUtils<Long,String>("did", "dname").converter((List<Dept>) map.get("allDepts"))) ;
		mav.addObject("allItems", new ListToMapUtils<Long,String>("iid", "title").converter((List<Item>) map.get("allItems"))) ;
		mav.addObject("allLevels", new ListToMapUtils<String,String>("lid", "title").converter((List<Level>) map.get("allLevels"))) ;
		mav.addObject("allTypes", new ListToMapUtils<Long,String>("tpid", "title").converter((List<Type>) map.get("allTypes"))) ;
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
