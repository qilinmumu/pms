package edu.fjnu.pms.dto;

public class UpdateMissionDTO {
	private Integer missionId;
	private String remark;
	private String progress;
	private String status;

	public UpdateMissionDTO() {
		super();
	}

	public Integer getMissionId() {
		return missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
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
		builder.append("UpdateMissionDTO [missionId=");
		builder.append(missionId);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", progress=");
		builder.append(progress);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
