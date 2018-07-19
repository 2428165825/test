package org.renting.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "`USERS`")
public class Users implements Serializable{
	/*字段*/
	@Id
	@Column(name = "`U_ID`")
	private Integer u_id;			//用户id
	@Column(name = "`NAME`")
	private String name;			//用户名
	@Column(name = "`PASSWORD`")
	private String password;		//密码
	@Column(name = "`TELEPHONE`")
	private String telePhone;		//电话
	@Column(name = "`USERNAME`")
	private String userName;		//姓名
	@Column(name = "`ISADMIN`")
	private String isAdmin;			//是否是管理员
	
	@OneToMany(mappedBy = "users",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<House> house = new HashSet<House>();
	public Users() {
	}
	
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
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
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Set<House> getHouse() {
		return house;
	}
	public void setHouse(Set<House> house) {
		this.house = house;
	}
	
}
