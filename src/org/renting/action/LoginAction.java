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
	//�û�����
	private List<Users> list = new ArrayList<Users>();
	//���ݼ���
	private List<House> result = new ArrayList<House>();
	private Integer resultName = null;

	//new biz�Ķ���
	UsersBiz biz = new UsersBiz();
	HouseBiz hbiz = new HouseBiz();
	
	// �û���
	private String name;
	// ����
	private String password;
	private String message;

	public void validate() {
		if (this.getName() == null || this.getName().length() == 0) {
			addFieldError("name", "�û�������Ϊ��!");
		}
		if (this.getPassword() == null || this.getPassword().length() == 0) {
			addFieldError("password", "���벻��Ϊ��!");
		}
	}
	/**
	 * ��¼
	 */
	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		Users users = biz.findByName(name, password);
		// �ж��û���
		if (users != null) {
			// ��ȡsession
			Map<String, Object> session = null;
			resultName = users.getU_id();
			result = hbiz.findByU_Id(resultName);
			session = ActionContext.getContext().getSession();
			// ���û�������session
			session.put("name", users);
			return Action.SUCCESS;
		} else if ("Tom".equals(name) && "000".equals(password)) {
			list = biz.findAllUsersCH08();
			System.out.println(list.size());
			return "findUser";
		} else { // ��¼ʧ�ܣ�����error
			this.setMessage("��¼ʧ�ܣ������û����������Ƿ���ȷ");
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
