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
@Table(name = "servicesettings")
public class ServiceSettings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "time")
	private float time;
	@Column(name = "amount")
	private float amount;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public ServiceSettings(long id, float time, float amount, Service service) {
		super();
		this.id = id;
		this.time = time;
		this.amount = amount;
		this.service = service;
	}
	public ServiceSettings(float time, float amount, Service service) {
		super();
		this.time = time;
		this.amount = amount;
		this.service = service;
	}
	
	public ServiceSettings() {}
}
