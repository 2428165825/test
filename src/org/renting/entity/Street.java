package org.renting.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "`STREET`")
public class Street implements Serializable {
	@Id
	@Column(name = "`ID`")
	private Integer id;
	@Column(name = "`NAME`")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "`DISTRICT_ID`")
	private District district;
	
	@OneToMany(mappedBy = "streets",cascade ={CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<House> houses = new HashSet<House>();

	public Street() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Set<House> getHouses() {
		return houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	public Street(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
