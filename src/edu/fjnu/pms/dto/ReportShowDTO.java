/**
 * 
 */
package edu.fjnu.pms.dto;

/**
 * @author lzx
 * 
 */
public class ReportShowDTO {
	private String userName;
	private String modifyTime;
	private String task;
	private String question;
	private String nextPlan;
	private String remark;

	public ReportShowDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getNextPlan() {
		return nextPlan;
	}

	public void setNextPlan(String nextPlan) {
		this.nextPlan = nextPlan;
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
		builder.append("ReportShowDTO [userName=");
		builder.append(userName);
		builder.append(", modifyTime=");
		builder.append(modifyTime);
		builder.append(", task=");
		builder.append(task);
		builder.append(", question=");
		builder.append(question);
		builder.append(", nextPlan=");
		builder.append(nextPlan);
		builder.append(", remark=");
		builder.append(remark);
		builder.append("]");
		return builder.toString();
	}

}
