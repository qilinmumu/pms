/**
 * 
 */
package edu.fjnu.pms.service.impl;

import java.util.List;

import edu.fjnu.pms.dao.impl.UserDaoImpl;
import edu.fjnu.pms.dao.inter.UserDaoInter;
import edu.fjnu.pms.domain.PmsUser;
import edu.fjnu.pms.exception.ApplicationException;
import edu.fjnu.pms.service.inter.UserServiceInter;
import edu.fjnu.pms.util.MD5Utils;

/**
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserServiceInter {
	private UserDaoInter userDao;
	
	public void setUserDao(UserDaoInter userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 添加用户对象
	 * @param user 用户对象
	 * @author lzx
	 */
	public void addUser(PmsUser user) {
		PmsUser userFind = this.findUserByAccount(user.getAccount());
		if (userFind == null) {
			MD5Utils md5Util = new MD5Utils();
			//对密码采取MD5加密
			String Md5Password = md5Util.getMD5(user.getPassword());
			user.setPassword(Md5Password);
			userDao.addUser(user);
		} else {
			throw new ApplicationException("账号已存在，请重新输入");
		}
	}
	
	/**
	 * 通过用户的账号查找用户对象
	 * @param account 账号
	 * @return 用户对象
	 * @author lzx
	 */
	public PmsUser findUserByAccount(String account) {
		PmsUser userFind = userDao.findUserByAccount(account);		
		return userFind;
	}

	/**
	 * 检查登录的账号密码是否正确，如不正确则抛出异常
	 * @param acocunt 账号
	 * @param password 密码
	 * @return 如果正确则返回用户对象，否则抛出异常
	 * @author lzx
	 */
	public PmsUser checkLogin(String account, String password) {
		MD5Utils md5Util = new MD5Utils();
		PmsUser userFind = this.findUserByAccount(account);
		if (userFind != null) {
			String passwordMd5 = md5Util.getMD5(password);
			if (passwordMd5.equals(userFind.getPassword())) {
				return userFind;
			} else {
				throw new ApplicationException("密码输入错误");
			}
		} else {
			throw new ApplicationException("账号不存在");
		}
	}

	/**
	 * 从数据库中查询所有用户，返回用户列表
	 * @return 如果查询成功，返回用户列表，如果查询失败，返回空列表
	 * @author lzx
	 */
	public List<PmsUser> getAllUser() {
		return userDao.getAllUser();
	}
	/**
	 * 通过用户id查找用户并返回用户对象
	 * @param userid  用户的主键id
	 * @return 返回的是一个用户对象
	 * @author Harry
	 */
	public PmsUser findUserById(Integer userid) {
		return userDao.findUserById(userid);
		
	}
}
