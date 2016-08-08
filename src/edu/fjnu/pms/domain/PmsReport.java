/**
 * 
 */
package edu.fjnu.pms.domain;

import java.util.Date;

/**
 * 汇报实体类，对应数据库中PMS_REPORT表
 * 
 * @author lzx
 */
public class PmsReport {
	private Integer reportId; // 汇报id
	private String todayTask; // 今日完成任务
	private String todayQuestion; // 今日遇到问题
	private String plan; // 明日计划
	private String remark; // 备注
	private Date modifyTime; // 修改时间
	private PmsUser pmsUser; // 所属用户
	
	public PmsReport() {
		super();
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getTodayTask() {
		return todayTask;
	}

	public void setTodayTask(String todayTask) {
		this.todayTask = todayTask;
	}

	public String getTodayQuestion() {
		return todayQuestion;
	}

	public void setTodayQuestion(String todayQuestion) {
		this.todayQuestion = todayQuestion;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public PmsUser getPmsUser() {
		return pmsUser;
	}

	public void setPmsUser(PmsUser pmsUser) {
		this.pmsUser = pmsUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PmsReport [reportId=");
		builder.append(reportId);
		builder.append(", todayTask=");
		builder.append(todayTask);
		builder.append(", todayQuestion=");
		builder.append(todayQuestion);
		builder.append(", plan=");
		builder.append(plan);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", modifyTime=");
		builder.append(modifyTime);
		builder.append("]");
		return builder.toString();
	}

}
