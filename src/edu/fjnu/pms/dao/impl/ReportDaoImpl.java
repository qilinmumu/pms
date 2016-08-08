/**
 * 
 */
package edu.fjnu.pms.dao.impl;

import java.util.Date;
import java.util.List;

import edu.fjnu.pms.dao.basic.BasicDaoImpl;
import edu.fjnu.pms.dao.inter.ReportDaoInter;
import edu.fjnu.pms.domain.PmsReport;
import edu.fjnu.pms.util.DateUtils;

/**
 * 任务汇报表的Dao实现
 * @author lzx
 */
public class ReportDaoImpl extends BasicDaoImpl implements ReportDaoInter {
	/**
	 * 添加汇报记录到数据库中
	 * @param report 汇报对象
	 * @author lzx
	 */
	public void addReport(PmsReport report) {
		this.add(report);
	}

	/**
	 * 跟新汇报记录到数据库中
	 * @param report 汇报对象
	 * @author lzx
	 */
	public void updateReport(PmsReport report) {
		this.update(report);
	}

	/**
	 * 通过id在数据库中查找汇报
	 * @param id 汇报id
	 * @return 汇报对象
	 * @author lzx
	 */
	public PmsReport findReportById(Integer id) {
		return (PmsReport) this.findById(PmsReport.class, id);
	}

	/**
	 * 通过id在数据库中查找当天的汇报
	 * @param id 用户id
	 * @return 汇报对象
	 * @author lzx
	 */
	public PmsReport getTodayReport(Integer id) {
		//获得当天的开始时间，即00:00:00
		Date beginTime = DateUtils.getDefinedTime(0, 0, 0);
		//获得当前的结束时间，即23:59:59
		Date endTime = DateUtils.getDefinedTime(23, 59, 59);
		
		PmsReport report = null;
		List<PmsReport> reportList = null;
		Object[] values = {
				id,
				beginTime,
				endTime
		};
		reportList = this.executeQuery("from PmsReport where userId = ? and modifyTime between ? and ?", values);
		if (!reportList.isEmpty()) {
			report = reportList.get(0);
		}
		return report;
	}

	/**
	 * 通过用户id，查找出该用户的所有汇报信息，分页查找
	 * @param id 用户id
	 * @param pageNow 当前页码
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回汇报列表，如果查询失败返回空列表
	 * @author lzx
	 */
	public List<PmsReport> getReportByUserIdByPage(Integer id, Integer pageNow, Integer pageSize) {
		List<PmsReport> reportList = null;
		Object[] values = {id};
		reportList = this.executeQueryByPage("from PmsReport where userId = ? order by modifyTime desc", values, pageNow, pageSize);
		return reportList;
	}

	/**
	 * 分页查找所有用户的汇报信息
	 * @param pageNow 当前页码
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回汇报列表，如果查询失败返回空列表
	 * @author lzx
	 */
	public List<PmsReport> getAllReportByPage(Integer pageNow, Integer pageSize) {
		List<PmsReport> reportList = null;
		reportList = this.executeQueryByPage("from PmsReport order by modifyTime desc", null, pageNow, pageSize);
		return reportList;
	}

	/**
	 * 通过id统计汇报的总记录数
	 * @param id 用户id
	 * @return 返回总记录数
	 * @author lzx
	 */
	public Integer getCountReportByUserIdByPage(Integer id) {
		Number count = (Number)this.uniqueQuery("select count(*) from PmsReport report where report.pmsUser.userId = ?", new Object[]{id});
		return count.intValue();
	}

	/**
	 * 统计汇报的总记录数
	 * @return 返回总记录数
	 * @author lzx
	 */
	public Integer getCountReportByPage() {
		Number count = (Number)this.uniqueQuery("select count(*) from PmsReport", null);
		return count.intValue();
	}

}
