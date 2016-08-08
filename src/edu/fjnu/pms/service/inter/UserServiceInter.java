/**
 * 
 */
package edu.fjnu.pms.service.inter;

import java.util.List;

import edu.fjnu.pms.domain.PmsUser;

/**
 * 用户表的Service接口
 * @author lzx
 */
public interface UserServiceInter {
	/**
	 * 添加用户对象
	 * @param user 用户对象
	 * @author lzx
	 */
	public void addUser(PmsUser user);
	
	/**
	 * 通过用户的账号查找用户对象
	 * @param account 账号
	 * @return 用户对象
	 * @author lzx
	 */
	public PmsUser findUserByAccount(String account);
	
	/**
	 * 检查登录的账号密码是否正确，如不正确则抛出异常
	 * @param acocunt 账号
	 * @param password 密码
	 * @return 如果正确则返回用户对象，否则抛出异常
	 * @author lzx
	 */
	public PmsUser checkLogin(String account, String password);
	
	/**
	 * 从数据库中查询所有用户，返回用户列表
	 * @return 如果查询成功，返回用户列表，如果查询失败，返回空列表
	 * @author lzx
	 */
	public List<PmsUser> getAllUser();
	/**
	 * 通过用户id查找用户并返回用户对象
	 * @param userid  用户的主键id
	 * @return 返回的是一个用户对象
	 * @author Harry
	 */
	public PmsUser findUserById(Integer userid);
	
}
