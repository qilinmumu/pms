/**
 * 
 */
package edu.fjnu.pms.dao.impl;

import java.util.List;

import edu.fjnu.pms.dao.basic.BasicDaoImpl;
import edu.fjnu.pms.dao.inter.UserDaoInter;
import edu.fjnu.pms.domain.PmsUser;

/**
 * 用户表的Dao实现
 * @author lzx
 */
public class UserDaoImpl extends BasicDaoImpl implements UserDaoInter {
	/**
	 * 添加用户到数据库
	 * @param user 用户对象
	 * @author lzx
	 */
	public void addUser(PmsUser user) {
		this.add(user);
	}

	/**
	 * 通过用户的账号查找用户对象
	 * @param account 账号
	 * @return 用户对象
	 * @author lzx
	 */
	public PmsUser findUserByAccount(String account) {
		PmsUser user = null;
		List<PmsUser> userList = null;
		Object[] values = {account};
		userList = this.executeQuery("from PmsUser u where u.account=?", values);
		if (!userList.isEmpty()) {
			user = userList.get(0);
		}
		return user;
	}

	/**
	 * 从数据库中查询所有用户，返回用户列表
	 * @return 如果查询成功，返回用户列表，如果查询失败，返回空列表
	 * @author lzx
	 */
	public List<PmsUser> getAllUser() {
		return this.executeQuery("from PmsUser", null);
	}
	
	/**
	 * 通过用户id查找用户并返回用户对象
	 * @param userid  用户的主键id
	 * @return 返回的是一个用户对象
	 * @author Harry
	 */
	public PmsUser findUserById(Integer userid) {
		return (PmsUser) this.findById(PmsUser.class,userid);
	}
	 
}
