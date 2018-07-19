package org.renting.action;

import com.opensymphony.xwork2.ActionSupport;

public class doLoginAction extends ActionSupport{
	private String nextDispose;
	/**
	 * execute方法，当Struts2 处理用户请求时，在默认配置下调用的方法
	 */
	private boolean manager;
	//动态结果
	public String doLogin() {
		if (isManager()) {
			nextDispose="manager";
		}else {
			nextDispose="common";
		}
		System.out.println(this.getNextDispose());
		return "success";
	}

	public String getNextDispose() {
		return nextDispose;
	}
	public void setNextDispose(String nextDispose) {
		this.nextDispose = nextDispose;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
}
