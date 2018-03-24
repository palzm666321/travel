package cn.mldn.travel.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.travel.vo.Emp;
import cn.mldn.util.dao.IBaseDAO;

public interface IEmpDAO extends IBaseDAO<String, Emp> {
	/**
	 * 主要是为了查询出所有的部门的领导信息，所以查询所有雇员信息
	 * @return 返回所有雇员信息
	 */
	public List<Emp> findAllManager();
	
	/**
	 * 更新一个雇员对应的级别处理
	 * @param vo 雇员信息
	 * @return 更新成功返回true
	 */
	public boolean doUpdateLevel(Emp vo);
	
	public List<Emp> findAllSplit(Map<String, Object> param);

	public Long getAllCount(Map<String, Object> param);
}
