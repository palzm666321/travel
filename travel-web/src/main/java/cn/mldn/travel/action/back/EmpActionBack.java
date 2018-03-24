package cn.mldn.travel.action.back;

import java.util.HashMap;
import java.util.Locale;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.travel.service.back.IEmpServiceBack;
import cn.mldn.travel.service.exception.DeptManagerExistException;
import cn.mldn.travel.vo.Emp;
import cn.mldn.util.action.abs.AbstractBaseAction;
import cn.mldn.util.enctype.PasswordUtil;
import cn.mldn.util.web.FileUtils;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpActionBack extends AbstractBaseAction {
	private static final String FLAG = "雇员";

	@Resource
	private IEmpServiceBack empServiceBack;
	
	@RequestMapping("add_pre")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.add.page"));
		mav.addAllObjects(this.empServiceBack.getAddPre());
		return mav;
	}

	@RequestMapping("add")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	public ModelAndView add(Emp vo, MultipartFile pic, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		FileUtils fileUtil=null;
		vo.setIneid(super.getEid());//通过Session取得当前操作者的雇员编号
		vo.setPassword(PasswordUtil.getPassword(vo.getPassword()));//密码加密处理
		if(!pic.isEmpty()) {//如果现在有文件上传
			fileUtil=new FileUtils(pic);
			vo.setPhoto(fileUtil.createFileName());//把生成的文件名称保存在vo类之中
		}
		try {
			if(this.empServiceBack.add(vo)) {
				if(fileUtil != null) {//准备上传文件
					fileUtil.saveFile(request, "upload/member/", vo.getPhoto());
				}
				super.setUrlAndMsg(request, "emp.add.action", "vo.add.success", FLAG);
			}else {
				super.setUrlAndMsg(request, "emp.add.action", "vo.add.failure", FLAG);
			}
		}catch(DeptManagerExistException e) {
			super.setUrlAndMsg(request, "emp.add.action", "emp.add.dept.mgr.failure");
		}
		return mav;
	}
	
	@RequestMapping("add_check")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	public ModelAndView check(HttpServletResponse response,String eid) {
		super.print(response,this.empServiceBack.getEid(eid)==null);
		return null;
	}
	

	@RequestMapping("edit_pre")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	public ModelAndView editPre(String eid) {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.edit.page"));
		return mav;
	}

	@RequestMapping("edit")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	public ModelAndView edit(Emp vo, MultipartFile pic, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "emp.list.action", "vo.edit.failure",
		// FLAG);
		super.setUrlAndMsg(request, "emp.list.action", "vo.edit.success", FLAG);
		return mav;
	}

	@RequestMapping("get")
	@RequiresUser
	@RequiresRoles(value={ "emp", "empshow" }, logical = Logical.OR)
	@RequiresPermissions(value={ "emp:get", "empshow:get" },logical=Logical.OR)
	public ModelAndView get(String eid, HttpServletResponse response) {
		Map<String,Object> map=this.empServiceBack.getDetails(eid);
		JSONObject json=new JSONObject();
		json.put("emp", map.get("emp"));
		json.put("dept", map.get("dept"));
		json.put("level", map.get("level"));
		super.print(response,json);
		return null;
	}

	@RequestMapping("list")
	@RequiresUser
	@RequiresRoles(value = { "emp", "empshow" }, logical = Logical.OR)
	@RequiresPermissions(value = { "emp:list", "empshow:list" }, logical = Logical.OR)
	public ModelAndView list(String ids, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.list.page"));
		return mav;
	}

	@RequestMapping("delete")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:delete")
	public ModelAndView delete(String ids, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "emp.list.action", "vo.delete.failure",
		// FLAG);
		super.setUrlAndMsg(request, "emp.list.action", "vo.delete.success", FLAG);
		return mav;
	}
}
