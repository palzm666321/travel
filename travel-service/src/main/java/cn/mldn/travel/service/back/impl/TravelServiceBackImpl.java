package cn.mldn.travel.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
