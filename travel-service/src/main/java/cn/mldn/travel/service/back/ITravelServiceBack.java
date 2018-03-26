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
}
