package cn.mldn.travel.action.back;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.travel.service.back.IDeptServiceBack;
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;
import cn.mldn.util.action.abs.AbstractBaseAction;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/pages/back/admin/dept/*")
public class DeptActionBack extends AbstractBaseAction {
	
	@Resource
	private IDeptServiceBack deptServiceBack;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("list")
	@RequiresUser
	@RequiresRoles(value = { "emp", "empshow" }, logical = Logical.OR)
	@RequiresPermissions(value = { "dept:list", "deptshow:list" }, logical = Logical.OR)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("dept.list.page"));
		Map<String,Object> map=this.deptServiceBack.list();
		Map<String,Object> empMap=new HashMap<String,Object>();
		List<Emp> list=(List<Emp>) map.get("allEmps"); //取得所有的雇员信息
		Iterator<Emp> it=list.iterator();
		while(it.hasNext()) {
			Emp emp=it.next();
			empMap.put(emp.getEid(), emp.getEname());
		}
		mav.addObject("allEmps",empMap);
		mav.addObject("allDepts",map.get("allDepts"));// 保存所有的部门信息
		return mav;
	}

	@RequestMapping("edit")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("dept:edit")
	public ModelAndView edit(HttpServletResponse response,Long did) {
		super.print(response,this.deptServiceBack.editLevel(did,super.getEid()));
		return null;
	}
	
	@RequestMapping("mgr")
	@RequiresUser
	@RequiresRoles(value = { "emp" }, logical = Logical.OR)
	@RequiresPermissions(value = { "dept:edit", "emp:edit" }, logical = Logical.AND)
	public ModelAndView editMgr(HttpServletResponse response,Long did) {
		super.print(response,this.deptServiceBack.editLevel(did,super.getEid()));
		return null;
	}
}
