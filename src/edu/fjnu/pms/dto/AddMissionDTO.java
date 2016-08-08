package edu.fjnu.pms.dto;

import java.util.Date;

public class AddMissionDTO {
	private Integer userId;
	private String task;
	private Date start;
	private Date end;
	private String remark;

	public AddMissionDTO() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddMissionDTO [userId=");
		builder.append(userId);
		builder.append(", task=");
		builder.append(task);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append(", remark=");
		builder.append(remark);
		builder.append("]");
		return builder.toString();
	}

}
