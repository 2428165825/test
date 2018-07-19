package org.renting.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.renting.entity.House;
import org.renting.entity.Users;
import org.renting.service.HouseBiz;
import org.renting.service.UsersBiz;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	//用户集合
	private List<Users> list = new ArrayList<Users>();
	//房屋集合
	private List<House> result = new ArrayList<House>();
	private Integer resultName = null;

	//new biz的对象
	UsersBiz biz = new UsersBiz();
	HouseBiz hbiz = new HouseBiz();
	
	// 用户名
	private String name;
	// 密码
	private String password;
	private String message;

	public void validate() {
		if (this.getName() == null || this.getName().length() == 0) {
			addFieldError("name", "用户名不能为空!");
		}
		if (this.getPassword() == null || this.getPassword().length() == 0) {
			addFieldError("password", "密码不能为空!");
		}
	}
	/**
	 * 登录
	 */
	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		Users users = biz.findByName(name, password);
		// 判断用户名
		if (users != null) {
			// 获取session
			Map<String, Object> session = null;
			resultName = users.getU_id();
			result = hbiz.findByU_Id(resultName);
			session = ActionContext.getContext().getSession();
			// 将用户名存入session
			session.put("name", users);
			return Action.SUCCESS;
		} else if ("Tom".equals(name) && "000".equals(password)) {
			list = biz.findAllUsersCH08();
			System.out.println(list.size());
			return "findUser";
		} else { // 登录失败，返回error
			this.setMessage("登录失败，请检查用户名和密码是否正确");
			return Action.ERROR;
		}
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public List<House> getResult() {
		return result;
	}

	public void setResult(List<House> result) {
		this.result = result;
	}

	public Integer getResultName() {
		return resultName;
	}
	public void setResultName(Integer resultName) {
		this.resultName = resultName;
	}
	
}
