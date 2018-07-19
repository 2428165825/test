package org.renting.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "`HOUSE`")
public class House implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "`H_ID`")
	private Integer id;
	@Column(name = "`TITLE`")
	private String title;
	@Column(name = "`DESCRIPTION`")
	private String description;
	@Column(name = "`PRICE`")
	private Double price;
	@Column(name = "`PUBDATE`")
	private Date pubDate;
	@Column(name = "`FLOORAGE`")
	private Integer floorage;
	@Column(name = "`CONTACT`")
	private String contact;
	
	@ManyToOne
	@JoinColumn(name = "`TYPE_ID`")
	private Type type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "`USER_ID`")
	private Users users;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "`STREET_ID`")
	private Street streets;
	
	public House(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public Integer getFloorage() {
		return floorage;
	}
	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Street getStreets() {
		return streets;
	}
	public void setStreets(Street streets) {
		this.streets = streets;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
