/**
 * 
 */
package edu.fjnu.pms.domain;

import java.util.Date;

/**
 * 任务实体类，对应数据库中PMS_TASK表
 * 
 * @author lzx
 */
public class PmsTask {
	private Integer taskId; // 任务id
	private String content; // 任务内容
	private Date createTime; // 创建时间
	private Date taskStart; // 任务开始时间
	private Date taskEnd; // 任务结束时间
	private String progress; // 进度
	private Date modifyTime; // 修改时间
	private String remark; // 备注
	private String status; // 状态
	private PmsUser pmsUser; // 所属用户
	
	public PmsTask() {
		super();
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getTaskStart() {
		return taskStart;
	}

	public void setTaskStart(Date taskStart) {
		this.taskStart = taskStart;
	}

	public Date getTaskEnd() {
		return taskEnd;
	}

	public void setTaskEnd(Date taskEnd) {
		this.taskEnd = taskEnd;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		builder.append("PmsTask [taskId=");
		builder.append(taskId);
		builder.append(", content=");
		builder.append(content);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", taskStart=");
		builder.append(taskStart);
		builder.append(", taskEnd=");
		builder.append(taskEnd);
		builder.append(", progress=");
		builder.append(progress);
		builder.append(", modifyTime=");
		builder.append(modifyTime);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
