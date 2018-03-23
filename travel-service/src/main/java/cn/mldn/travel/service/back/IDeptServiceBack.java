package cn.mldn.travel.service.back;

import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

public interface IDeptServiceBack{
	/**
	 * 列出全部的部门的完整信息
	 * @return 返回的集合包含有如下数据：<br>
	 *         1、key = allDepts、value = 所有的部门信息集合；<br>
	 *         2、key = allEmps、value = 部门的所有领导信息集合。<br>
	 */
	public Map<String,Object> list();
	
}
