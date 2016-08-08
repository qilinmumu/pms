/**
 * 
 */
package edu.fjnu.pms.dao.impl;

import java.util.List;

import edu.fjnu.pms.dao.basic.BasicDaoImpl;
import edu.fjnu.pms.dao.inter.TaskDaoInter;
import edu.fjnu.pms.domain.PmsTask;

/**
 * 任务表的Dao实现
 * @author lzx
 */
public class TaskDaoImpl extends BasicDaoImpl implements TaskDaoInter {
	/**
	 * 将任务添加到数据当中
	 * @param task 任务对象
	 * @author Harry
	 */
	public void addTask(PmsTask task) {
		this.add(task);
	}
	
	/**
	 * 通过用户id，分页查找任务
	 * @param id 用户id
	 * @param pageNow 当前页码，从1开始
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回任务列表，否则返回空列表
	 * @author lzx
	 */
	public List<PmsTask> findUserTaskByPage(Integer id, Integer pageNow, Integer pageSize){
		Object[] values = {id};
		List<PmsTask> taskList = this.executeQueryByPage("from PmsTask where userId = ? order by createTime desc", values, pageNow, pageSize);
		return taskList;
	}

	/**
	 * 分页查找所有人的任务
	 * @param pageNow 当前页码，从1开始
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回任务列表，否则返回空列表
	 * @author lzx
	 */
	public List<PmsTask> findAllTaskByPage(Integer pageNow, Integer pageSize) {
		List<PmsTask> taskList = this.executeQueryByPage("from PmsTask order by modifyTime desc", null, pageNow, pageSize);
		return taskList;
	}

	/**
	 * 通过任务内容和用户id来查找任务
	 * @param content 任务内容
	 * @param id 用户id
	 * @return 如果查找成功返回任务对象，否则返回null
	 * @author lzx
	 */
	public PmsTask findTaskByContentAndUserId(String content, Integer id) {
		List<PmsTask> taskList = null;
		PmsTask task = null;
		Object[] values = {
				id,
				content
		};
		taskList = this.executeQuery("from PmsTask where userId = ? and content = ?", values);
		if (!taskList.isEmpty()) {
			task = taskList.get(0);
		}
		return task;
	}

	/**
	 * 更新任务
	 * @param task 任务对象
	 * @author lzx
	 */
	public void updateTask(PmsTask task) {
		this.update(task);
	}

	/**
	 * 通过userId计算出用户的任务记录条数
	 * @param userId 用户id
	 * @return 返回记录条数
	 * @author lzx
	 */
	public Integer getCountTaskByUserIdByPage(Integer userId) {
		Object[] params = {userId};
		Number count = (Number)this.uniqueQuery("select count(*) from PmsTask t where t.pmsUser.userId = ?", params);
		return count.intValue();
	}

	/**
	 * 计算出用户的任务记录条数
	 * @return 返回记录条数
	 * @author lzx
	 */
	public Integer getCountTasByPage() {
		Number count = (Number)this.uniqueQuery("select count(*) from PmsTask", null);
		return count.intValue();
	}

	/**
	 * 通过id查找出任务对象
	 * @param id 任务的主键id
	 * @return 如果查找成功返回任务对象，否则返回null
	 * @author lzx
	 */
	public PmsTask findTaskById(Integer id) {
		return (PmsTask) this.findById(PmsTask.class, id);
	}

}
