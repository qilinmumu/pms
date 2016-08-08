/**
 * 
 */
package edu.fjnu.pms.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类，对应数据库中PMS_USER表
 * 
 * @author lzx
 */
public class PmsUser {
	private Integer userId; // 用户id
	private String name; // 姓名
	private String account; // 账号
	private String password; // 密码
	private Integer permission; // 权限
	
	Set<PmsTask> pmsTasks = new HashSet<PmsTask>();	//对应的任务
	Set<PmsReport> pmsReports = new HashSet<PmsReport>();	//对应的汇报

	public PmsUser() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public Set<PmsTask> getPmsTasks() {
		return pmsTasks;
	}

	public void setPmsTasks(Set<PmsTask> pmsTasks) {
		this.pmsTasks = pmsTasks;
	}

	public Set<PmsReport> getPmsReports() {
		return pmsReports;
	}

	public void setPmsReports(Set<PmsReport> pmsReports) {
		this.pmsReports = pmsReports;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PmsUser [userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", account=");
		builder.append(account);
		builder.append(", password=");
		builder.append(password);
		builder.append(", permission=");
		builder.append(permission);
		builder.append("]");
		return builder.toString();
	}

}
