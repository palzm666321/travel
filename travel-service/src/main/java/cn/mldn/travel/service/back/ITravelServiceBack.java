package cn.mldn.travel.service.back;

import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

import cn.mldn.travel.vo.Travel;
import cn.mldn.travel.vo.TravelEmp;

public interface ITravelServiceBack {
	/**
	 * 进行出差申请单填写的处理
	 * @return 包含有如下的返回结果：<br>
	 * 1、key = allItems、value = 所有的出差分类；<br>
	 */
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:add" }, logical = Logical.OR)
	public Map<String,Object> addPre() ;
	/**
	 * 出差填写，结束日期应该在开始日期之后处理
	 * @param vo 出差单信息
	 * @return 成功返回true
	 */
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:add" }, logical = Logical.OR)
	public boolean add(Travel vo) ;
	
	/**
	 * 进行所有个人申请单的列表显示
	 * @param seid 当前的经理信息
	 * @param currentPage 当前页
	 * @param lineSize 每页行
	 * @param column 模糊列
	 * @param keyWord 关键字
	 * @return 返回如下的数据内容 <br>
	 * 1、key=allTravels，value=全部的出差列表；<br>
	 * 2、key=allRecorders，value=出差单个数
	 */
	@RequiresRoles(value = { "travel" }, logical = Logical.OR)
	@RequiresPermissions(value = { "travel:self" }, logical = Logical.OR)
	public Map<String,Object> listSelf(String seid,long currentPage,int lineSize,String column,String keyWord);
	
	
	/**
	 * 进行出差申请单填写的处理，能修改的申请单申请状态只能是9
	 * @param tid 要修改的申请单编号
	 * @return 包含有如下的返回结果
	 * 1、key=allItems，value=所有的出差分类；<br>
	 * 1、key=travel，value=单个申请单；<br>
	 */ 
	@RequiresRoles(value= {"travel"},logical=Logical.OR)
	@RequiresPermissions(value= {"travel:edit"},logical=Logical.OR)
	public Map<String,Object> editPre(Long tid);
	
	/**
	 * 出差填写，结束日期应该在开始日期之后处理
	 * @param vo 出差单信息
	 * @return 成功返回true
	 */
	@RequiresRoles(value= {"travel"},logical=Logical.OR)
	@RequiresPermissions(value= {"travel:edit"},logical=Logical.OR)
	public boolean edit(Travel vo);
	
	
	/**
	 * 删除指定的差旅信息项
	 * @param vo 要删除的差旅信息
	 * @return 删除成功返回true
	 */
	@RequiresRoles(value= {"travel"},logical=Logical.OR)
	@RequiresPermissions(value= {"travel:delete"},logical=Logical.OR)
	public boolean delete(Travel vo);
	
	/**
	 * 根据指定的出差编号列出该出差操作中所有的员工信息以及所有的部门信息
	 * @param tid 差旅编号
	 * @return 返回如下数据
	 * 1、key=allDepts，value=所有的部门信息；
	 * 2、key=emp，value=出差发布者的雇员信息
	 */
	@RequiresRoles(value= {"travel"},logical=Logical.OR)
	@RequiresPermissions(value= {"travel:edit"},logical=Logical.OR)
	public Map<String,Object> listEmp(long tid);
	
	/**
	 * 进行出差人员配置的信息加载处理
	 * @param did 部门编号
	 * @param currentPage 页
	 * @param lineSize 行
	 * @param column 列
	 * @param keyWord 关键字
	 * @return 返回如下数据内容；<br>
	 * 1、key=allEmps，value=所有的雇员信息；
	 * 2、key=allRecorders，value=雇员个数
	 */
	@RequiresRoles(value= {"travel"},logical=Logical.OR)
	@RequiresPermissions(value= {"travel:edit"},logical=Logical.OR)
	public Map<String,Object> listByDept(long did,long currentPage,int lineSize,String column,String keyWord);
	
	
	/**
	 * 进行出差待选人员的配置
	 * @param vo 包括有出差编号，待选的雇员编号
	 * @return 返回的结果包含有如下信息；<br>
	 * 1、key=status、value=是否追加成功的标记（true，false）<br>
	 * 2、key=emp、value=新增雇员的信息；<br>
	 * 3、key=dept、value=雇员所在的部门信息；<br>
	 * 4、key=level、value=级别信息<br>
	 */
	public Map<String,Object> addTravelEmp(TravelEmp vo);
	
	/**
	 * 删除指定的出差人员信息
	 * @param vo 包括出差编号，待选的雇员编号
	 * @return 删除成功返回true
	 */
	public boolean deleteTravelEmp(TravelEmp vo);
	
	/**
	 * 进行出差人员配置的信息加载处理
	 * @param tid 本次编辑的差旅信息编号
	 * @param did 部门编号
	 * @param currentPage 页
	 * @param lineSize 行
	 * @param column 列
	 * @param keyWord 关键字
	 * @return 返回如下内容;<br>
	 * 1、key=allEmps，value=所有雇员的信息；<br>
	 * 1、key=allRecorders，value=雇员的个数。
	 */
	@RequiresRoles(value= {"travel"},logical=Logical.OR)
	@RequiresPermissions(value= {"travel:edit"},logical=Logical.OR)
	public Map<String,Object> listByDept(long tid,long did,long currentPage,int lineSize,String column,String keyWord);
	
	
	
}
