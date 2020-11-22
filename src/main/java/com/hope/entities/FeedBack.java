package com.hope.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class FeedBack implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "content")
	private String content;
	@Column(name = "rating")
	private float rating;
	@Column(name = "type")
	private int type;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public FeedBack() {
		// TODO Auto-generated constructor stub
	}
	public FeedBack(long id, String content, float rating, int type, Account account, Service service) {
		super();
		this.id = id;
		this.content = content;
		this.rating = rating;
		this.type = type;
		this.account = account;
		this.service = service;
	}
	public FeedBack(String content, float rating, int type, Account account, Service service) {
		super();
		this.content = content;
		this.rating = rating;
		this.type = type;
		this.account = account;
		this.service = service;
	}
	
}	
