package org.renting.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="`DISTRICT`")
public class District implements Serializable{
	@Id
	@Column(name = "`DISTRICTID`")
	private Integer districtid;
	@Column(name = "`DISTRICTNAME`")
	private String districtname;
	
	@OneToMany(mappedBy = "district",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<Street> streets = new HashSet<Street>();
	
	public District(){}
	
	public Integer getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public Set<Street> getStreets() {
		return streets;
	}
	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}
	public District(Integer districtid, String districtname) {
		this.districtid = districtid;
		this.districtname = districtname;
	}
	
}
