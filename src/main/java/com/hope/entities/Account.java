package com.hope.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "address")
	private String address;
	@Column(name = "created_at")
	private Date created_at;
	@Column(name = "mail")
	private String mail;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private boolean status;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<Service> service;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<Payment> payment;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<FeedBack> feedback;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Set<Service> getService() {
		return service;
	}
	public void setService(Set<Service> service) {
		this.service = service;
	}
	public Set<Payment> getPayment() {
		return payment;
	}
	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	public Set<FeedBack> getFeedback() {
		return feedback;
	}
	public void setFeedback(Set<FeedBack> feedback) {
		this.feedback = feedback;
	}
	public Account(long id, String address, Date created_at, String mail, String name, String password, boolean status,
			Role role, Set<Service> service, Set<Payment> payment, Set<FeedBack> feedback) {
		super();
		this.id = id;
		this.address = address;
		this.created_at = created_at;
		this.mail = mail;
		this.name = name;
		this.password = password;
		this.status = status;
		this.role = role;
		this.service = service;
		this.payment = payment;
		this.feedback = feedback;
	}
	public Account() {}
	public Account(String address, Date created_at, String mail, String name, String password, boolean status,
			Role role, Set<Service> service, Set<Payment> payment, Set<FeedBack> feedback) {
		super();
		this.address = address;
		this.created_at = created_at;
		this.mail = mail;
		this.name = name;
		this.password = password;
		this.status = status;
		this.role = role;
		this.service = service;
		this.payment = payment;
		this.feedback = feedback;
	}
	
	
	
}
