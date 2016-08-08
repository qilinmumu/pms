/**
 * 
 */
package edu.fjnu.pms.service.inter;

import java.util.List;

import edu.fjnu.pms.domain.PmsReport;

/**
 * 任务汇报表的Service接口
 * @author lzx
 */
public interface ReportServiceInter {
	/**
	 * 添加汇报记录到数据库中
	 * @param report 汇报对象
	 * @author lzx
	 */
	public void addReport(PmsReport report);
	
	/**
	 * 跟新汇报记录到数据库中
	 * @param report 汇报对象
	 * @author lzx
	 */
	public void updateReport(PmsReport report);
	
	/**
	 * 通过id在数据库中查找汇报
	 * @param id 汇报id
	 * @return 汇报对象
	 * @author lzx
	 */
	public PmsReport findReportById(Integer id);
	
	/**
	 * 通过id在数据库中查找当天的汇报
	 * @param id 用户id
	 * @return 汇报对象
	 * @author lzx
	 */
	public PmsReport getTodayReport(Integer id);
	
	/**
	 * 通过用户id，查找出该用户的所有汇报信息,转换成JSON
	 * @param id 用户id
	 * @return JSON字符串
	 * @author lzx
	 */
	public String getReportByUserIdByPage(Integer id, Integer pageNow, Integer pageSize);
	
	/**
	 * 分页查找所有用户的汇报信息,转换成JSON
	 * @param pageNow 当前页码
	 * @param pageSize 每页记录数
	 * @return JSON字符串
	 * @author lzx
	 */
	public String getAllReportByPage(Integer pageNow, Integer pageSize);
	
	/**
	 * 通过id统计汇报的总记录数
	 * @param id 用户id
	 * @return 返回总记录数
	 * @author lzx
	 */
	public Integer getCountReportByUserIdByPage(Integer id);
	
	/**
	 * 统计汇报的总记录数
	 * @return 返回总记录数
	 * @author lzx
	 */
	public Integer getCountReportByPage();
	
}
