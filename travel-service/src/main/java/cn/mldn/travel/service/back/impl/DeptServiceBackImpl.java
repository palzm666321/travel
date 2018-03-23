package cn.mldn.travel.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.travel.dao.IDeptDAO;
import cn.mldn.travel.dao.IEmpDAO;
import cn.mldn.travel.service.back.IDeptServiceBack;
import cn.mldn.travel.service.util.abs.AbstractService;


@Service
public class DeptServiceBackImpl extends AbstractService implements IDeptServiceBack{
	
	@Resource
	private IDeptDAO deptDAO;
	@Resource
	private IEmpDAO empDAO;
	
	@Override
	public Map<String, Object> list() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("allEmps", this.empDAO.findAllManager());
		map.put("allDepts", this.deptDAO.findAll());
		return map;
	}
	
}
