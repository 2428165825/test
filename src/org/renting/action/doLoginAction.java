package org.renting.action;

import com.opensymphony.xwork2.ActionSupport;

public class doLoginAction extends ActionSupport{
	private String nextDispose;
	/**
	 * execute��������Struts2 �����û�����ʱ����Ĭ�������µ��õķ���
	 */
	private boolean manager;
	//��̬���
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
