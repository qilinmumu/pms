package edu.fjnu.pms.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.fjnu.pms.domain.PmsTask;
import edu.fjnu.pms.domain.PmsUser;
import edu.fjnu.pms.dto.AddMissionDTO;
import edu.fjnu.pms.dto.UpdateMissionDTO;
import edu.fjnu.pms.service.impl.TaskServiceImpl;
import edu.fjnu.pms.service.impl.UserServiceImpl;
import edu.fjnu.pms.service.inter.TaskServiceInter;
import edu.fjnu.pms.service.inter.UserServiceInter;
import edu.fjnu.pms.util.DateUtils;

/**
 * @author lzx
 */
public class MissionAction extends ActionSupport implements SessionAware {
	private UserServiceInter userService;
	private TaskServiceInter taskService;
	private Map<String, Object> session;

	private List<PmsUser> userList;
	private AddMissionDTO addMissionDTO;
	private UpdateMissionDTO updateMissionDTO;
	private Integer pageNumber;
	private Integer pageSize;
	private String tip;
	
	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public void setTaskService(TaskServiceInter taskService) {
		this.taskService = taskService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<PmsUser> getUserList() {
		return userList;
	}

	public void setUserList(List<PmsUser> userList) {
		this.userList = userList;
	}

	public AddMissionDTO getAddMissionDTO() {
		return addMissionDTO;
	}

	public void setAddMissionDTO(AddMissionDTO addMissionDTO) {
		this.addMissionDTO = addMissionDTO;
	}

	public UpdateMissionDTO getUpdateMissionDTO() {
		return updateMissionDTO;
	}

	public void setUpdateMissionDTO(UpdateMissionDTO updateMissionDTO) {
		this.updateMissionDTO = updateMissionDTO;
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

	/**
	 * 显示添加任务的界面
	 * @return
	 * @throws Exception
	 * @author lzx
	 */
	public String inputMission() throws Exception {
		// 得到所有用户
		this.userList = userService.getAllUser();
		return "showInput";
	}

	/**
	 * 将任务添加到数据库中
	 * 
	 * @return
	 * @throws Exception
	 * @author lzx
	 */
	public String addMission() throws Exception {
		System.out.println(addMissionDTO);
		// 根据用户id获取对应的用户对象
		PmsUser user = userService.findUserById(addMissionDTO.getUserId());
		// 声明一个task对象，并对其进行set操作
		PmsTask task = new PmsTask();
		task.setContent(addMissionDTO.getTask());
		task.setTaskStart(addMissionDTO.getStart());
		task.setTaskEnd(addMissionDTO.getEnd());
		task.setRemark(addMissionDTO.getRemark());
		task.setCreateTime(new Date());
		task.setModifyTime(new Date());
		task.setProgress("0");
		task.setStatus("未完成");
		task.setPmsUser(user);

		// 保存task到数据库中
		taskService.addTask(task);
		tip = "添加成功";
		return INPUT;
	}

	/**
	 * 显示查看任务的界面
	 * 
	 * @return
	 * @throws Exception
	 * @author lzx
	 */
	public String showMission() throws Exception {
		return "showMission";
	}

	/**
	 * ajax分页加载用户的任务，以json格式返回
	 * 
	 * @throws Exception
	 * @author lzx
	 */
	public void ajaxLoadPersonMission() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");

		// 得到当前系统登录用户
		PmsUser user = (PmsUser) session.get("user");
		// 得到用户任务信息的json字符串
		String missionJson = taskService.findUserTaskByPage(user.getUserId(), pageNumber, pageSize);
		// 得到用户任务总记录数
		Integer total = taskService.getCountTaskByUserIdByPage(user.getUserId());

		String mission = "{\"total\":" + total + ",\"rows\":" + missionJson + "}";
		response.getWriter().print(mission);

	}

	/**
	 * ajax分页加载所有的任务，以json格式返回
	 * @throws Exception
	 * @author lzx
	 */
	public void ajaxLoadTeamMission() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");

		// 得到所有的任务的json
		String missionJson = taskService
				.findAllTaskByPage(pageNumber, pageSize);
		// 得到所有任务的总记录数
		Integer total = taskService.getCountTasByPage();

		String mission = "{\"total\":" + total + ",\"rows\":" + missionJson + "}";
		response.getWriter().print(mission);
	}
	
	public String updateMisstion() throws Exception {
		PmsTask task = taskService.findTaskById(updateMissionDTO.getMissionId());
		task.setRemark(updateMissionDTO.getRemark());
		task.setProgress(updateMissionDTO.getProgress());
		task.setStatus(updateMissionDTO.getStatus());
		task.setModifyTime(new Date());
		
		taskService.updateTask(task);
		return "showMission";
	}

}
