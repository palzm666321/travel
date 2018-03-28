package cn.mldn.travel.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.travel.dao.IDeptDAO;
import cn.mldn.travel.dao.IEmpDAO;
import cn.mldn.travel.dao.IItemDAO;
import cn.mldn.travel.dao.ITravelDAO;
import cn.mldn.travel.service.back.ITravelServiceBack;
import cn.mldn.travel.service.util.abs.AbstractService;
import cn.mldn.travel.vo.Travel;
@Service
public class TravelServiceBackImpl extends AbstractService
		implements
			ITravelServiceBack {
	@Resource
	private IItemDAO itemDAO ;
	@Resource
	private ITravelDAO travelDAO ;
	@Resource
	private IDeptDAO deptDAO;
	@Resource
	private IEmpDAO empDAO;
	
	
	@Override
	public Map<String, Object> addPre() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allItems", this.itemDAO.findAll()) ;
		return map;
	}

	@Override
	public boolean add(Travel vo) {
		if (vo.getSdate().before(vo.getEdate())) {	// 开始日期在结束日期之前
			vo.setAudit(9); 	// 状态设置为9表示该出差单未提交
			return this.travelDAO.doCreate(vo) ;
		}
		return false;
	}

	@Override
	public Map<String, Object> listSelf(String seid, long currentPage, int lineSize, String column, String keyWord) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> param = super.handleParam(currentPage, lineSize, column, keyWord);
		param.put("seid", seid);
		map.put("allTravels", this.travelDAO.findAllSplit(param));
		map.put("allRecorders", this.travelDAO.getAllCount(param)) ;
		return map;
	}
	
	
	@Override
	public Map<String, Object> editPre(Long tid) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("allItems", this.itemDAO.findAll());
		Travel travel=this.travelDAO.findById(tid);
		if(travel.getAudit().equals(9)) {
			map.put("travel", travel);
		}
		return map;
	}
	
	
	@Override
	public boolean edit(Travel vo) {
		if(vo.getSdate().before(vo.getEdate())) {//开始日期在结束日期之前
			return this.travelDAO.doUpdate(vo);
		}
		return false;
	}

	@Override
	public boolean delete(Travel vo) {
		return this.travelDAO.doRemoveSelf(vo);
	}

	@Override
	public Map<String, Object> listEmp(long tid) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("allDepts", this.deptDAO.findAll());
		map.put("emp", this.empDAO.findByTravel(tid));
		return map;
	}
	
	@Override
	public Map<String, Object> listByDept(long did, long currentPage, int lineSize, String column, String keyWord) {
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> param=super.handleParam(currentPage, lineSize, column, keyWord);
		param.put("did", did);
		map.put("allEmps", this.empDAO.findAllByDept(param));
		map.put("allRecorders", this.empDAO.getAllCountByDept(param));
		return map;
	}
}
