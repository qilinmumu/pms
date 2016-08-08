/**
 * 
 */
package edu.fjnu.pms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import edu.fjnu.pms.dao.impl.TaskDaoImpl;
import edu.fjnu.pms.dao.inter.TaskDaoInter;
import edu.fjnu.pms.domain.PmsTask;
import edu.fjnu.pms.domain.PmsUser;
import edu.fjnu.pms.dto.ShowMissionDTO;
import edu.fjnu.pms.service.inter.TaskServiceInter;
import edu.fjnu.pms.util.DateUtils;

/**
 * 任务表的Service实现
 * @author Harry
 *
 */
public class TaskServiceImpl implements TaskServiceInter {
	private TaskDaoInter taskDao;
	
	public void setTaskDao(TaskDaoInter taskDao) {
		this.taskDao = taskDao;
	}
	
	/**
	 * 将任务添加到数据当中
	 * @param task 任务对象
	 * @author Harry
	 */
	public void addTask(PmsTask task) {
		taskDao.addTask(task);
	}
	
	/**
	 * 通过用户id，分页查找任务
	 * @param id 用户id
	 * @param pageNow 当前页码，从1开始
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回任务列表，否则返回空列表
	 * @author lzx
	 */
	public String findUserTaskByPage(Integer id, Integer pageNow,
			Integer pageSize) {
		Gson gson = new Gson();
		List<PmsTask> taskList = taskDao.findUserTaskByPage(id, pageNow, pageSize);
		List<ShowMissionDTO> missionDTOs = new ArrayList<ShowMissionDTO>();
		ShowMissionDTO missionDTO = null;
		for(PmsTask task : taskList) {
			missionDTO = new ShowMissionDTO();
			missionDTO.setMissionId(task.getTaskId());
			missionDTO.setUserName(task.getPmsUser().getName());
			missionDTO.setTask(task.getContent());
			missionDTO.setProgress(task.getProgress());
			missionDTO.setCreate(DateUtils.dateToString(task.getCreateTime(), "yyyy-MM-dd  HH:mm:ss"));
			missionDTO.setStart(DateUtils.dateToString(task.getTaskStart(), "yyyy-MM-dd"));
			missionDTO.setEnd(DateUtils.dateToString(task.getTaskEnd(), "yyyy-MM-dd"));
			missionDTO.setModify(DateUtils.dateToString(task.getModifyTime(), "yyyy-MM-dd  HH:mm:ss"));
			missionDTO.setRemark(task.getRemark());
			missionDTO.setStatus(task.getStatus());
			missionDTOs.add(missionDTO);
		}
		return gson.toJson(missionDTOs);
	}

	/**
	 * 分页查找所有人的任务
	 * @param pageNow 当前页码，从1开始
	 * @param pageSize 每页记录数
	 * @return 如果查询成功，返回任务列表，否则返回空列表
	 * @author lzx
	 */
	public String findAllTaskByPage(Integer pageNow, Integer pageSize) {
		Gson gson = new Gson();
		List<PmsTask> taskList = taskDao.findAllTaskByPage(pageNow, pageSize);
		List<ShowMissionDTO> missionDTOs = new ArrayList<ShowMissionDTO>();
		ShowMissionDTO missionDTO = null;
		for(PmsTask task : taskList) {
			missionDTO = new ShowMissionDTO();
			missionDTO.setUserName(task.getPmsUser().getName());
			missionDTO.setTask(task.getContent());
			missionDTO.setProgress(task.getProgress());
			missionDTO.setCreate(DateUtils.dateToString(task.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
			missionDTO.setStart(DateUtils.dateToString(task.getTaskStart(), "yyyy-MM-dd"));
			missionDTO.setEnd(DateUtils.dateToString(task.getTaskEnd(), "yyyy-MM-dd"));
			missionDTO.setModify(DateUtils.dateToString(task.getModifyTime(), "yyyy-MM-dd  HH:mm:ss"));
			missionDTO.setRemark(task.getRemark());
			missionDTO.setStatus(task.getStatus());
			missionDTOs.add(missionDTO);
		}
		return gson.toJson(missionDTOs);
	}

	/**
	 * 通过任务内容和用户id来查找任务
	 * @param content 任务内容
	 * @param id 用户id
	 * @return 如果查找成功返回任务对象，否则返回null
	 * @author lzx
	 */
	public PmsTask findTaskByContentAndUserId(String content, Integer id) {
		return taskDao.findTaskByContentAndUserId(content, id);
	}

	/**
	 * 更新任务
	 * @param task 任务对象
	 * @author lzx
	 */
	public void updateTask(PmsTask task) {
		taskDao.updateTask(task);
	}

	/**
	 * 通过userId计算出用户的任务记录条数
	 * @param userId 用户id
	 * @return 返回记录条数
	 * @author lzx
	 */
	public Integer getCountTaskByUserIdByPage(Integer userId) {
		return taskDao.getCountTaskByUserIdByPage(userId);
	}

	/**
	 * 计算出用户的任务记录条数
	 * @return 返回记录条数
	 * @author lzx
	 */
	public Integer getCountTasByPage() {
		return taskDao.getCountTasByPage();
	}

	/**
	 * 通过id查找出任务对象
	 * @param id 任务的主键id
	 * @return 如果查找成功返回任务对象，否则返回null
	 * @author lzx
	 */
	public PmsTask findTaskById(Integer id) {
		return taskDao.findTaskById(id);
	}

}
