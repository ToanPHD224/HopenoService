package com.hope.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "serviceoverview")
public class ServiceOverView {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "content")
	private String content;
	@Column(name = "image")
	private String image;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public ServiceOverView(long id, String content, String image, Service service) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.service = service;
	}
	public ServiceOverView(String content, String image, Service service) {
		super();
		this.content = content;
		this.image = image;
		this.service = service;
	}
	public ServiceOverView() {}

}
