package org.renting.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "`TYPE`")
public class Type {
	@Id
	@Column(name = "`ID`")
	private Integer id;
	@Column(name = "`NAME`")
	private String name;
	@OneToMany(mappedBy = "type",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<House> house = new HashSet<House>();
	
	public Type(){}
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
	
}
