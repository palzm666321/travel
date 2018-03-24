package cn.mldn.travel.service.back;

import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

import cn.mldn.travel.service.exception.DeptManagerExistException;
import cn.mldn.travel.service.exception.LevelNotEnoughException;
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;

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
	public Map<String,Object> getAddPre();
	
	/**
	 * 实现雇员信息的追加，该方法要执行如下的操作;<br>
	 * 1、要判断当前追加的雇员编号信息是否存在，如果存在则无法添加；<br>
	 * 2、随后根据增加雇员级别，来判断所在的部门情况，如果是该部门已经存在有经理，那么将无法进行保存，应该抛出异常;<br>
	 * 3、判断当前操作者的级别是否为经理，如果为经理才可以进行经理的相关处理;<br>
	 * 4、进行雇员信息的保存；
	 * @param vo 包含有新雇员的信息
	 * @return 增加成功返回true，如果重名或增加失败返回false
	 * @throws DeptManagerExistException 如果现在该部门存在有经理，则抛出异常
	 */
	public boolean add(Emp vo)throws DeptManagerExistException;
	
	/**
	 * 调用IEmpDAO.findById()方法根据eid查询雇员信息
	 * @param eid 雇员编号
	 * @return 如果有雇员返回对象
	 */
	public Emp getEid(String eid);
	
	/**
	 * 进行全部雇员信息的数据列表显示处理，该处理要执行如下操作；<br>
	 * 1、调用ILevelDAO.findAll()方法取得全部的级别信息；<br>
	 * 2、调用IDeptDAO.findAll()方法取得全部部门信息；<br>
	 * 3、嗲用IEmpDAO.findAllSplit()方法进行全部雇员数据的分页查询；<br>
	 * 4、调用IEmpDAO.findAllCount()方法进行全部雇员数量的查询;<br>
	 * @param currentPage 当前页
	 * @param lineSize 每页显示行
	 * @param column 模糊查询列
	 * @param keyWord 关键字
	 * @return 包含有如下的数据组成；<br>
	 * 1、key=allDepts，value=全部部门信息；<br>
	 * 2、key=allLevels，value=全部级别信息；<br>
	 * 3、key=allEmps，value=全部雇员信息；<br>
	 * 4、key=allRecorders，value=雇员总量；<br>
	 */
	public Map<String,Object> list(long currentPage,int lineSize,String column,String keyWord);
	
	
	/**
	 * 实现雇员信息的编辑，该方法要执行如下的操作；<br>
	 * 1、随后根据增加雇员级别，来判断所在的部门情况，如果是该部门已经存在有经理，那么将无法进行保存，应该抛出异常；<br>
	 * 2、判断当前操作者的级别是否为经理，如果为经理才可以进行经理的相关处理；<br>
	 * 3、进行雇员信息的保存；
	 * @param vo 包含有要修改的雇员信息
	 * @return 增加成功返回true，如果重名或增加失败返回false
	 * @throws DeptManagerExistException 如果现在该部门存在有经理，则抛出异常
	 * @throws LevelNotEnoughException 如果现在该等级不是经理（"manager"），则抛出异常
	 */
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	public boolean edit(Emp vo)throws DeptManagerExistException,LevelNotEnoughException;
	
	/**
	 * 进行雇员数据追加前的信息查询处理，该方法要执行如下操作；<br>
	 * 1、调用IDeptDAO.findAll()取得全部的部门信息;<br>
	 * 2、调用ILevelDAO.findAll()取得全部的级别信息;<br>
	 * 3、调用IEmpDAO.findById()方法取得要修改的雇员信息；<br>
	 * @param eid 要修改的雇员编号
	 * @return 返回有如下的数据内容
	 * 1、key=allDepts，value=全部部门信息；<br>
	 * 2、key=allLevels，value=全部级别信息；<br>
	 * 3、key=emp，value=雇员信息；<br>
	 */ 
	public Map<String,Object> getEditPre(String eid);
}
