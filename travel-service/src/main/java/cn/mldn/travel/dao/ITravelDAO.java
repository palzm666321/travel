package cn.mldn.travel.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.travel.vo.Travel;
import cn.mldn.travel.vo.TravelCost;
import cn.mldn.travel.vo.TravelEmp;
import cn.mldn.util.dao.IBaseDAO;

public interface ITravelDAO extends IBaseDAO<Long, Travel> {
	/**
	 * 要进行指定的差旅信息的删除操作
	 * @param vo 包含有要删除的差旅编号以及要处理的用户编号
	 * @return 删除成功返回true
	 */
	public boolean doRemoveSelf(Travel vo);
	
	/**
	 * 进行travel_emp表的处理
	 * @param vo 包含有差旅编号、出差待选编号
	 * @return 追加成功返回true
	 */
	public boolean doCreateTravelEmp(TravelEmp vo);
	
	/**
	 * 进行travel_emp表的删除处理，根据差旅编号和雇员编号删除
	 * @param vo 包含有差旅编号，出差待选编号
	 * @return 删除成功返回true
	 */
	public boolean doRemoveTravelEmp(TravelEmp vo);
	
	/**
	 * 增加出差花费的信息项，需要考虑增长后的id问题
	 * @param vo 费用信息
	 * @return 保存成功返回true
	 */
	public boolean doCreateTravelCost(TravelCost vo);
	
	/**
	 * 查询出指定出差费用的全部费用信息
	 * @param tid 出差编号
	 * @return 费用信息
	 */
	public List<TravelCost> findAllTravelCost(long tid);
	
	
	/**
	 * 移除某一个支出费用项
	 * @param tcid 费用编号
	 * @return 成功返回true
	 */
	public boolean doRemoveTravelCost(long tcid);
	
	/**
	 * 根据费用编号查询费用单
	 * @param tcid 费用编号
	 * @return 费用单
	 */
	public Travel findTravelByCost(long tcid);
	
	/**
	 * 要进行出差单的申请处理操作
	 * @param vo 包含有要更新的出差单数据
	 * @return 成功返回true
	 */
	public boolean doUpdateSubmit(Travel vo);
	
	
	/**
	 * 统计出指定出差信息的所有雇员人数
	 * @param tid 出差信息编号
	 * @return 统计的人数结果
	 */
	public Integer getTravelEmpCount(long tid) ; 
	
	/**
	 * 统计指定状态下的数据量
	 * @param param 包含有如下内容；<br>
	 * 1、key=column、value=模糊查询列；<br>
	 * 2、key=keyWord、value=查询关键字；<br>
	 * 3、key=audit、value=审核状态;<br>
	 * @return 统计量
	 */
	public Long getAllCountByAudit(Map<String,Object> param);
	
	/**
	 * 进行指定审核状态的所有申请单列表
	 * @param param 包含有如下内容;<br>
	 * 1、key=start、value=开始行；<br>
	 * 2、key=lineSize、value=每页长度；<br>
	 * 3、key=column、value=模糊查询列；<br>
	 * 4、key=keyWord、value=查询关键字；<br>
	 * 5、key=audit、value=审核状态<br>
	 * @return 差旅信息
	 */
	public List<Travel> findAllByAudit(Map<String,Object> param);
	
	/**
	 * 进行出差单的审核处理操作
	 * @param vo 审核信息
	 * @return 成功返回true
	 */
	public boolean doUpdateAudit(Travel vo);
	
	/**
	 * 统计通过的出差申请数据量
	 * @param param 包含有如下内容：<br>
	 * 1、key=column、value=模糊查询列；<br>
	 * 2、key=keyWord、value=查询关键字；<br>
	 * @return 统计量
	 */
	public Long getAllCountPass(Map<String,Object> param);
	
	/**
	 * 查找所有通过的出差单信息
	 * @param param 包含有如下内容： <br>
	 * 1、key=start、value=开始行；<br>
	 * 2、key=lineSize、value=每页长度；<br>
	 * 3、key=column、value=模糊查询列;<br>
	 * 4、key=keyWord、value=查询关键字;<br>
	 * @return 差旅信息
	 */
	public List<Travel> findAllPass(Map<String,Object> param);
	
}
