package cn.mldn.travel.dao;

import cn.mldn.travel.vo.Travel;
import cn.mldn.util.dao.IBaseDAO;

public interface ITravelDAO extends IBaseDAO<Long, Travel> {
	/**
	 * 要进行指定的差旅信息的删除操作
	 * @param vo 包含有要删除的差旅编号以及要处理的用户编号
	 * @return 删除成功返回true
	 */
	public boolean doRemoveSelf(Travel vo);
}
