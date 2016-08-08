/**
 * 
 */
package edu.fjnu.pms.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.fjnu.pms.domain.PmsUser;
import edu.fjnu.pms.service.impl.UserServiceImpl;
import edu.fjnu.pms.service.inter.UserServiceInter;


/**
 * @author lzx
 */
public class UserAction extends ActionSupport implements SessionAware{
	private UserServiceInter userService;
	private Map<String, Object> session;
	private String account;
	private String password;

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	/**
	 * 跳转到登录界面
	 * @return input字符串
	 * @author lzx
	 */
	public String toLogin() throws Exception{
		session.remove("user");
		return INPUT;
	}

	/**
	 * 验证用户的登录请求
	 * @return 登录成功返回success字符串
	 * @author lzx
	 */
	public String checkLogin() throws Exception{
		//调用service方法判断账号密码是否正确
		PmsUser user = userService.checkLogin(account, password);
		//保存用户到session中
		session.put("user", user);
		return SUCCESS;
	}
	
	public void validateCheckLogin() {
		if(account == null || account.trim().equals("")) {
			this.addFieldError("accountError", "账号不能为空");
		}
		if (password == null || password.trim().equals("")) {
			this.addFieldError("passwordError", "密码不能为空");
		}
	}
	
}
