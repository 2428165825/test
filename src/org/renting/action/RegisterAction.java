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
			addFieldError("username", "用户名不能为空");
		}
		if (this.getPassword().length()<6) {
			addFieldError("password", "密码长度须大于6位");
		}
		if (this.getRepassword().length() != this.getPassword().length() || !this.getRepassword().equals(this.getPassword())) {
			addFieldError("repassword", "两次输入的密码不一样");
		}
		if (this.getTelephone().length()<11) {
			addFieldError("telephone", "电话号码长度不得低于11位");
		}
	}
	@Override
	public String execute() throws Exception {
		// 注册判断全部是否为空
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
