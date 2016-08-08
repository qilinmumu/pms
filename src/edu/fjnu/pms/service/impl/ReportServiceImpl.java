/**
 * 
 */
package edu.fjnu.pms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import edu.fjnu.pms.dao.impl.ReportDaoImpl;
import edu.fjnu.pms.dao.inter.ReportDaoInter;
import edu.fjnu.pms.domain.PmsReport;
import edu.fjnu.pms.dto.ReportShowDTO;
import edu.fjnu.pms.service.inter.ReportServiceInter;
import edu.fjnu.pms.util.DateUtils;

/**
 * 任务汇报表的Service实现
 * @author lzx
 */
public class ReportServiceImpl implements ReportServiceInter {
	private ReportDaoInter reportDao;
	
	public void setReportDao(ReportDaoInter reportDao) {
		this.reportDao = reportDao;
	}
	
	/**
	 * 添加汇报记录到数据库中
	 * @param report 汇报对象
	 * @author lzx
	 */
	public void addReport(PmsReport report) {
		reportDao.add(report);
	}

	/**
	 * 跟新汇报记录到数据库中
	 * @param report 汇报对象
	 * @author lzx
	 */
	public void updateReport(PmsReport report) {
		reportDao.updateReport(report);
	}

	/**
	 * 通过id在数据库中查找汇报
	 * @param id 汇报id
	 * @return 汇报对象
	 * @author lzx
	 */
	public PmsReport findReportById(Integer id) {
		return reportDao.findReportById(id);
	}

	/**
	 * 通过id在数据库中查找当天的汇报
	 * @param id 用户id
	 * @return 汇报对象
	 * @author lzx
	 */
	public PmsReport getTodayReport(Integer id) {
		return reportDao.getTodayReport(id);
	}

	/**
	 * 通过用户id，查找出该用户的所有汇报信息,转换成JSON
	 * @param id 用户id
	 * @return JSON字符串
	 * @author lzx
	 */
	public String getReportByUserIdByPage(Integer id, Integer pageNow, Integer pageSize) {
		Gson gson = new Gson();
		List<PmsReport> reportList = reportDao.getReportByUserIdByPage(id, pageNow, pageSize);
		List<ReportShowDTO> reportShowDTOs = new ArrayList<ReportShowDTO>();
		ReportShowDTO reportShowDTO = null;
		for(PmsReport report : reportList) {
			reportShowDTO = new ReportShowDTO();
			reportShowDTO.setUserName(report.getPmsUser().getName());
			reportShowDTO.setModifyTime(DateUtils.dateToString(report.getModifyTime(), "yyyy-MM-dd HH:mm:ss"));
			reportShowDTO.setTask(report.getTodayTask());
			reportShowDTO.setQuestion(report.getTodayQuestion());
			reportShowDTO.setNextPlan(report.getPlan());
			reportShowDTO.setRemark(report.getRemark());
			reportShowDTOs.add(reportShowDTO);
		}
		return gson.toJson(reportShowDTOs);
	}

	/**
	 * 分页查找所有用户的汇报信息,转换成JSON
	 * @param pageNow 当前页码
	 * @param pageSize 每页记录数
	 * @return JSON字符串
	 * @author lzx
	 */
	public String getAllReportByPage(Integer pageNow, Integer pageSize) {
		Gson gson = new Gson();
		List<PmsReport> reportList = reportDao.getAllReportByPage(pageNow, pageSize);
		List<ReportShowDTO> reportShowDTOs = new ArrayList<ReportShowDTO>();
		ReportShowDTO reportShowDTO = null;
		for(PmsReport report : reportList) {
			reportShowDTO = new ReportShowDTO();
			reportShowDTO.setUserName(report.getPmsUser().getName());
			reportShowDTO.setModifyTime(DateUtils.dateToString(report.getModifyTime(), "yyyy-MM-dd HH:mm:ss"));
			reportShowDTO.setTask(report.getTodayTask());
			reportShowDTO.setQuestion(report.getTodayQuestion());
			reportShowDTO.setNextPlan(report.getPlan());
			reportShowDTO.setRemark(report.getRemark());
			reportShowDTOs.add(reportShowDTO);
		}
		return gson.toJson(reportShowDTOs);
	}

	/**
	 * 通过id统计汇报的总记录数
	 * @param id 用户id
	 * @return 返回总记录数
	 * @author lzx
	 */
	public Integer getCountReportByUserIdByPage(Integer id) {
		return reportDao.getCountReportByUserIdByPage(id);
	}

	/**
	 * 统计汇报的总记录数
	 * @return 返回总记录数
	 * @author lzx
	 */
	public Integer getCountReportByPage() {
		return reportDao.getCountReportByPage();
	}

}
