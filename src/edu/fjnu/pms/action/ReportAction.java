/**
 * 
 */
package edu.fjnu.pms.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.fjnu.pms.domain.PmsReport;
import edu.fjnu.pms.domain.PmsUser;
import edu.fjnu.pms.dto.ReportDTO;
import edu.fjnu.pms.service.impl.ReportServiceImpl;
import edu.fjnu.pms.service.inter.ReportServiceInter;

/**
 * @author lzx
 * 
 */
public class ReportAction extends ActionSupport implements SessionAware {
	private ReportServiceInter reportService;
	private Map<String, Object> session;
	private ReportDTO reportDTO;
	private PmsReport report;
	private Integer pageNumber;
	private Integer pageSize;
	private String tip;

	
	public void setReportService(ReportServiceInter reportService) {
		this.reportService = reportService;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public ReportDTO getReportDTO() {
		return reportDTO;
	}

	public void setReportDTO(ReportDTO reportDTO) {
		this.reportDTO = reportDTO;
	}

	public PmsReport getReport() {
		return report;
	}

	public void setReport(PmsReport report) {
		this.report = report;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String showReport() throws Exception {
		PmsUser user = (PmsUser) session.get("user");
		report = reportService.getTodayReport(user.getUserId());
		return SUCCESS;
	}

	/**
	 * 添加每日汇报
	 * @return 如果添加成功返回success
	 * @author lzx
	 */
	public String addReport() throws Exception {
		PmsUser user = (PmsUser) session.get("user");
		System.out.println(reportDTO);
		// 创建对象，封装表单数据
		PmsReport report = null;
		if (!this.reportDTO.getReportId().equals("")) { // 表示当天已经存在汇报
			// 通过id查找出当天的汇报
			report = reportService.findReportById(Integer
					.parseInt(this.reportDTO.getReportId()));
			// 更新汇报中的内容
			report.setTodayTask(this.reportDTO.getTask());
			report.setTodayQuestion(this.reportDTO.getQuestion());
			report.setPlan(this.reportDTO.getPlan());
			report.setRemark(this.reportDTO.getRemark());
			report.setModifyTime(new Date());
			// 更新汇报
			reportService.updateReport(report);
		} else { // 表示当天第一次填写汇报
			// 新建汇报对象，封装表单数据
			report = new PmsReport();
			report.setTodayTask(this.reportDTO.getTask());
			report.setTodayQuestion(this.reportDTO.getQuestion());
			report.setPlan(this.reportDTO.getPlan());
			report.setRemark(this.reportDTO.getRemark());
			report.setPmsUser(user);
			report.setModifyTime(new Date());
			// 添加汇报
			reportService.addReport(report);
		}
		tip = "提交成功";
		return "showReport";
	}
	
	/**
	 * 跳转到查看汇报记录的界面
	 * @return
	 * @author lzx
	 */
	public String loadPersonReport(){
		return "showReportPage";
	}
	
	/**
	 * ajax获取当前登录用户的汇报记录。
	 * 使用分页获取
	 * @throws Exception
	 * @author lzx
	 */
	public void ajaxLoadPersonReport() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");

		// 得到当前系统登录用户
		PmsUser user = (PmsUser) session.get("user");
		// 通过id分页查找该用户的汇报
		String reportListJson = reportService.getReportByUserIdByPage(
				user.getUserId(), pageNumber, pageSize);
		// 通过id查找该用户的汇报总记录
		Integer total = reportService.getCountReportByUserIdByPage(user
				.getUserId());

		// 需要返回的数据有总记录数和行数据
		String reportJson = "{\"total\":" + total + ",\"rows\":" + reportListJson + "}";
		response.getWriter().print(reportJson);
	}

	/**
	 * ajax获取所有用户的汇报记录。
	 * 使用分页获取
	 * @throws Exception
	 * @author lzx
	 */
	public void ajaxLoadTeamReport() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");

		// 通过id分页查找该用户的汇报
		String reportListJson = reportService.getAllReportByPage(pageNumber,
				pageSize);
		// 通过id查找该用户的汇报总记录
		Integer total = reportService.getCountReportByPage();

		// 需要返回的数据有总记录数和行数据
		String reportJson = "{\"total\":" + total + ",\"rows\":" + reportListJson + "}";
		response.getWriter().print(reportJson);
	}

}
