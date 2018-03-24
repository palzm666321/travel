package cn.mldn.travel.service.back.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.travel.dao.IActionDAO;
import cn.mldn.travel.dao.IDeptDAO;
import cn.mldn.travel.dao.IEmpDAO;
import cn.mldn.travel.dao.ILevelDAO;
import cn.mldn.travel.dao.IRoleDAO;
import cn.mldn.travel.service.back.IEmpServiceBack;
import cn.mldn.travel.service.exception.DeptManagerExistException;
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;

@Service
public class EmpServiceBackImpl implements IEmpServiceBack {
	@Resource
	private IEmpDAO empDAO;
	@Resource
	private IRoleDAO roleDAO;
	@Resource
	private IActionDAO actionDAO;
	@Resource
	private ILevelDAO levelDAO;
	@Resource
	private IDeptDAO deptDAO;

	@Override
	public Map<String, Object> get(String eid, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		Emp emp = this.empDAO.findById(eid);
		if (emp != null) {
			if (password.equals(emp.getPassword())) {
				map.put("level", this.levelDAO.findById(emp.getLid()));
			}
		}
		map.put("emp", emp);
		return map;
	}

	@Override
	public Map<String, Set<String>> listRoleAndAction(String eid) {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		map.put("allRoles", this.roleDAO.findAllIdByEmp(eid));
		map.put("allActions", this.actionDAO.findAllIdByEmp(eid));
		return map;
	}

	@Override
	public Map<String, Object> getDetails(String eid) {
		Map<String,Object> map=new HashMap<String,Object>();
		Emp emp=this.empDAO.findById(eid);
		if(this.empDAO.findById(eid)!=null) {
			map.put("dept", this.deptDAO.findById(emp.getDid()));
			map.put("level", this.levelDAO.findById(emp.getLid()));
		}
		map.put("emp", emp);
		return map;
	}
 
	@Override
	public Map<String, Object> getAddPre() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("allLevels", this.levelDAO.findAll());
		map.put("allDepts", this.deptDAO.findAll());
		return map;
	}	
	
	@Override
	public boolean add(Emp vo) throws DeptManagerExistException {
		if(this.empDAO.findById(vo.getEid())==null) {//1、判断要追加的用户的id是否存在，如果存在则无法进行保存
			vo.setHiredate(new Date());//雇佣日期设置为当前日期
			vo.setLocked(0);//新增加用户默认为活跃状态
			//2、判断当前操作者的级别以及所在的部门信息，就需要首先取得操作者的相关信息
			Emp humanEmp=this.empDAO.findById(vo.getIneid());
			if(humanEmp.getDid().equals(2L)) {//判断当前的操作者是否是人事部门
				if("staff".equals(vo.getLid())) {//3、判断当前要追加的新雇员信息是否级别为普通员工
					return this.empDAO.doCreate(vo);
				}else {
					if("manager".equals(humanEmp.getLid())) {//操作者级别为manager经理
						Dept dept=this.deptDAO.findById(vo.getDid());//判断要处理的部门信息
						if(dept.getEid()==null) {//该部门现在没有经理
							if(this.empDAO.doCreate(vo)) {//保存新用户
								dept.setEid(vo.getEid());//新雇员为部门经理
								return this.deptDAO.doUpdateManager(dept);
							}
						}else {
							throw new DeptManagerExistException("该部门已经有经理，无法进行新任经理的添加！");
						}
					}
				}
			}
		}
		return false;
	}
}
