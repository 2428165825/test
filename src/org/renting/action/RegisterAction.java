package org.renting.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private String name;
	private String password;
	private String repassword;
	private String telephone;
	private String username;

	public void validate() {
		if (this.getUsername() == null) {
			addFieldError("username", "�û�������Ϊ��");
		}
		if (this.getPassword().length()<6) {
			addFieldError("password", "���볤�������6λ");
		}
		if (this.getRepassword().length() != this.getPassword().length() || !this.getRepassword().equals(this.getPassword())) {
			addFieldError("repassword", "������������벻һ��");
		}
		if (this.getTelephone().length()<11) {
			addFieldError("telephone", "�绰���볤�Ȳ��õ���11λ");
		}
	}
	@Override
	public String execute() throws Exception {
		// ע���ж�ȫ���Ƿ�Ϊ��
		if (name != null && password != null && repassword != null && telephone != null && username != null) {
			return "success";
		}else{
			return "fail";
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
