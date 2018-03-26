package cn.mldn.travel.service.back;

import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

import cn.mldn.travel.vo.Travel;

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
	
}
