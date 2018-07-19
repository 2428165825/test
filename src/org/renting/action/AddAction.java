package org.renting.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.renting.entity.House;
import org.renting.entity.Street;
import org.renting.entity.Type;
import org.renting.entity.Users;
import org.renting.service.HouseBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport{
	//�������ݶ����ȡҳ���ֵ
	private House house;
	//new����service����
	HouseBiz hbiz = new HouseBiz();
	private Integer resultName = null;
	//���ݼ���
	private List<House> result = new ArrayList<House>();
	
	@Override
	public String execute() throws Exception {
		Users user = (Users) ActionContext.getContext().getSession().get("name");			//�ҵ�sessionȥ��ȡ�����sessionֵ
		house.setUsers(user);
		hbiz.addHouseInfo(house);
		resultName = user.getU_id();
		result = hbiz.findByU_Id(resultName);
		return "add";
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Integer getResultName() {
		return resultName;
	}

	public void setResultName(Integer resultName) {
		this.resultName = resultName;
	}

	public List<House> getResult() {
		return result;
	}

	public void setResult(List<House> result) {
		this.result = result;
	}
	
}
