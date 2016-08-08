package edu.fjnu.pms.dto;

public class ShowMissionDTO {
	private Integer missionId;
	private String userName;
	private String task;
	private String progress;
	private String create;
	private String start;
	private String end;
	private String modify;
	private String remark;
	private String status;

	public ShowMissionDTO() {
		super();
	}

	public Integer getMissionId() {
		return missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShowMissionDTO [missionId=");
		builder.append(missionId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", task=");
		builder.append(task);
		builder.append(", progress=");
		builder.append(progress);
		builder.append(", create=");
		builder.append(create);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append(", modify=");
		builder.append(modify);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
