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

	
	
	/**
	 * 查询出所有指定编号的雇员信息
	 * @param eid 雇员编号
	 * @return 指定雇员信息
	 */
	public List<Emp> findAllByIds(Object eid[]);
	
	/**
	 * 进行locked字段的更新处理
	 * @param vo 主要需要的是用户编号以及用户的locked状态
	 * @return 更新成功返回true
	 */
	public boolean doUpdateLocked(Emp vo);
}
