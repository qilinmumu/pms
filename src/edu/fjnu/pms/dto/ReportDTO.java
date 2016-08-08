/**
 * 
 */
package edu.fjnu.pms.dto;

/**
 * @author lzx
 * 
 */
public class ReportDTO {
	private String reportId;
	private String task;
	private String question;
	private String plan;
	private String remark;

	public ReportDTO() {
		super();
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportDTO [reportId=");
		builder.append(reportId);
		builder.append(", task=");
		builder.append(task);
		builder.append(", question=");
		builder.append(question);
		builder.append(", plan=");
		builder.append(plan);
		builder.append(", remark=");
		builder.append(remark);
		builder.append("]");
		return builder.toString();
	}

}
