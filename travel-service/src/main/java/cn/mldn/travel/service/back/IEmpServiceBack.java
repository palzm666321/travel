package cn.mldn.travel.service.back;

import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

public interface IEmpServiceBack {
	/**
	 * 根据雇员id获得雇员完整信息
	 * @param eid 雇员编号
	 * @return 包括如下内容：<br>
	 * 1、key = emp、value = 雇员对象，如果该雇员不存在返回null<br>
	 * 2、如果雇员信息可以查询成功，则查询对应级别信息。key = level
	 */
	public Map<String,Object> get(String eid,String password) ;
	/**
	 * 根据雇员编号取得雇员对应的角色与权限数据信息，该操作主要执行如下功能：<br>
	 * 1、调用IRoleDAO.findAllIdByEmp()查询出所有的角色标记信息；<br>
	 * 2、调用IActionDAO.findAllIdByEmp()查询出所有的权限标记信息；<br>
	 * @param eid 要查询角色和权限的雇员编号
	 * @return 返回Map集合数据包含有如下内容：<br>
	 * 1、key = allRoles、value = 所有的角色标记信息；<br>
	 * 2、key = allActions、value = 所有的权限标记信息；<br>
	 */
	public Map<String,Set<String>> listRoleAndAction(String eid) ;
	
	/**
	 * 根据雇员编号取得雇员对应的角色与权限数据信息，该操作主要执行如下功能：<br>
	 * 1、调用IEmpDAO.findAll()查询出所有的雇员信息；<br>
	 * 2、调用IDeptDAO.findAll()查询出所有的部门信息；<br>
	 * 3、调用ILevelDAO.findAll()查询出所有的等级信息; <br>
	 * @param eid 雇员编号
	 * @return 返回Map集合数据包含有如下内容：<br>
	 * 1、key = allEmps、value = 所有的雇员信息；<br>
	 * 2、key = allDepts、value = 所有的部门信息；<br>
	 * 3、key = allLevel、value = 所有的等级信息
	 */
	@RequiresRoles(value= {"emp","empshow"},logical=Logical.OR)
	@RequiresPermissions(value= {"emp:edit","empshow:get"},logical=Logical.OR)
	public Map<String,Object> getDetails(String eid);
	
	/**
	 * 进行雇员数据追加前的信息查询处理，该方法要执行如下的操作；<br>
	 * 1、调用IDeptDAO.findAll()取得全部的部门信息;<br>
	 * 2、调用ILevelDAO.findAll()取得全部的级别信息；<br>
	 * @return 返回有如下的数据内容;<br>
	 * 1、key=allDepts，value=全部部门信息；<br>
	 * 2、key=allLevels，value=全部级别信息；<br>
	 */
	@RequiresRoles(value= {"emp"},logical=Logical.OR)
	@RequiresPermissions(value= {"emp:add"},logical=Logical.OR)
	public Map<String,Object> getAddPre();
	
	
}
