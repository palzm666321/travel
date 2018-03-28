package cn.mldn.travel.action.back;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.travel.service.back.ITravelServiceBack;
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Travel;
import cn.mldn.util.action.abs.AbstractBaseAction;
import cn.mldn.util.split.ActionSplitPageUtil;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/pages/back/admin/travel/*")
public class TravelActionBack extends AbstractBaseAction {
	private static final String FLAG = "出差申请";
	@Resource
	private ITravelServiceBack travelServiceBack;
	@RequestMapping("add_pre")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:add"}, logical = Logical.OR)
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.add.page"));
		mav.addAllObjects(this.travelServiceBack.addPre());
		return mav;
	}

	@RequestMapping("add")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:add"}, logical = Logical.OR)
	public ModelAndView add(HttpServletRequest request, Travel vo) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		vo.setSeid(super.getEid()); // 当前登录的id就是该出差单的提交者
		if (this.travelServiceBack.add(vo)) {
			super.setUrlAndMsg(request, "travel.add.action", "vo.add.success",
					FLAG);
		} else {
			super.setUrlAndMsg(request, "travel.add.action", "vo.add.failure",
					FLAG);
		}
		return mav;
	}

	@RequestMapping("list_emp")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:self"}, logical = Logical.OR)
	public ModelAndView listEmp(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.emp.page"));
		return mav;
	}

	@RequestMapping("list_self")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:self"}, logical = Logical.OR)
	public ModelAndView listSelf(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.self.page"));
		ActionSplitPageUtil aspu=new ActionSplitPageUtil(request, "申请标题:title", super.getMsg("travel.self.action"));
		mav.addAllObjects(this.travelServiceBack.listSelf(super.getEid(),aspu.getCurrentPage(), aspu.getLineSize(), aspu.getKeyWord(), aspu.getColumn()));
		return mav;
	}

	@RequestMapping("user_edit_pre")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:edit"}, logical = Logical.OR)
	public ModelAndView editUser(long tid) {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.user.page"));
		Map<String,Object> map=this.travelServiceBack.listEmp(tid);
		mav.addAllObjects(map);
		//为了方便进行部门信息的显示将部门信息由List集合变为Map集合
		List<Dept> allDepts=((List<Dept>)map.get("allDepts"));
		Map<Long,String> deptMap=new HashMap<Long,String>();
		Iterator<Dept> it=allDepts.iterator();
		while(it.hasNext()) {
			Dept dept=it.next();
			deptMap.put(dept.getDid(), dept.getDname());
		}
		mav.addObject("allDepts", deptMap);
		return mav;
	}

	@RequestMapping("cost_edit_pre")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:edit"}, logical = Logical.OR)
	public ModelAndView editCost() {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.cost.page"));
		return mav;
	}

	@RequestMapping("edit_pre")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:edit"}, logical = Logical.OR)
	public ModelAndView editPre(Long tid) {
		ModelAndView mav = new ModelAndView(super.getUrl("travel.edit.page"));
		mav.addAllObjects(this.travelServiceBack.editPre(tid));
		return mav;
	}

	@RequestMapping("edit")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:edit"}, logical = Logical.OR)
	public ModelAndView edit(HttpServletRequest request,Travel vo) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		vo.setSeid(super.getEid()); 
		if (this.travelServiceBack.edit(vo)) {
			super.setUrlAndMsg(request, "travel.self.action", "vo.edit.success",
					FLAG);
		} else {
			super.setUrlAndMsg(request, "travel.self.action", "vo.edit.failure",
					FLAG);
		}
		return mav;
	}

	@RequestMapping("delete")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:delete"}, logical = Logical.OR)
	public ModelAndView delete(HttpServletRequest request,Travel vo) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		vo.setSeid(super.getEid()); 
		if (this.travelServiceBack.delete(vo)) {
			super.setUrlAndMsg(request, "travel.self.action", "vo.delete.success",
					FLAG);
		} else {
			super.setUrlAndMsg(request, "travel.self.action", "vo.delete.failure",
					FLAG);
		}
		return mav;
	}

	@RequestMapping("submit")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:submit"}, logical = Logical.OR)
	public ModelAndView submit(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "travel.self.action",
		// "travel.submit.failure");
		super.setUrlAndMsg(request, "travel.self.action",
				"travel.submit.success");
		return mav;
	}
	
	

	@RequestMapping("emp_dept")
	@RequiresUser
	@RequiresRoles(value = {"travel"}, logical = Logical.OR)
	@RequiresPermissions(value = {"travel:edit"}, logical = Logical.OR)
	public ModelAndView listDept(HttpServletRequest request,HttpServletResponse response,long did) {
		JSONObject json=new JSONObject();
		ActionSplitPageUtil aspu=new ActionSplitPageUtil(request, "", "");
		Map<String,Object> map=this.travelServiceBack.listByDept(did, aspu.getCurrentPage(), aspu.getLineSize(), aspu.getColumn(), aspu.getKeyWord());
		json.put("allRecorders", map.get("allRecorders"));
		json.put("allEmps", map.get("allEmps"));
		super.print(response, json);
		return null;
	}
	
}
