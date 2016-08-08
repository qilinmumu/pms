/**
 * 
 */
package edu.fjnu.pms.dao.inter;

import java.util.List;

import edu.fjnu.pms.dao.basic.BasicDaoInter;
import edu.fjnu.pms.domain.PmsTask;

/**
 * 任务表的Dao接口
 * @author lzx
 */
public interface TaskDaoInter extends BasicDaoInter {
	/**
	 * 将任务添加到数据当中
	 * @param task 任务对象
	 * @author Harry
	 */
	public void addTask(PmsTask task);
	
	/**
	 * 通过用户id，分页查找任务
	 * @param id 用户id
	 * @param pageNow 当前页码，从1开始
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回任务列表，否则返回空列表
	 * @author lzx
	 */
	public List<PmsTask> findUserTaskByPage(Integer id, Integer pageNow, Integer pageSize);
	
	/**
	 * 分页查找所有人的任务
	 * @param pageNow 当前页码，从1开始
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回任务列表，否则返回空列表
	 * @author lzx
	 */
	public List<PmsTask> findAllTaskByPage(Integer pageNow, Integer pageSize);
	
	/**
	 * 通过任务内容和用户id来查找任务
	 * @param content 任务内容
	 * @param id 用户id
	 * @return 如果查找成功返回任务对象，否则返回null
	 * @author lzx
	 */
	public PmsTask findTaskByContentAndUserId(String content, Integer id);
	
	/**
	 * 更新任务
	 * @param task 任务对象
	 * @author lzx
	 */
	public void updateTask(PmsTask task);
	
	/**
	 * 通过userId计算出用户的任务记录条数
	 * @param userId 用户id
	 * @return 返回记录条数
	 * @author lzx
	 */
	public Integer getCountTaskByUserIdByPage(Integer userId);
	
	/**
	 * 计算出用户的任务记录条数
	 * @return 返回记录条数
	 * @author lzx
	 */
	public Integer getCountTasByPage();
	
	/**
	 * 通过id查找出任务对象
	 * @param id 任务的主键id
	 * @return 如果查找成功返回任务对象，否则返回null
	 * @author lzx
	 */
	public PmsTask findTaskById(Integer id);
}
