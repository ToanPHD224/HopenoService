package com.hope.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "service_fee")
public class ServiceFee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "booking_fee")
	private float booking_Fee;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "servicefee",cascade = CascadeType.ALL)
	private Set<Service> service;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getBooking_Fee() {
		return booking_Fee;
	}
	public void setBooking_Fee(float booking_Fee) {
		this.booking_Fee = booking_Fee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Service> getService() {
		return service;
	}
	public void setService(Set<Service> service) {
		this.service = service;
	}
	public ServiceFee(float booking_Fee, String name, Set<Service> service) {
		super();
		this.booking_Fee = booking_Fee;
		this.name = name;
		this.service = service;
	}
	public ServiceFee() {}
	public ServiceFee(long id, float booking_Fee, String name, Set<Service> service) {
		super();
		this.id = id;
		this.booking_Fee = booking_Fee;
		this.name = name;
		this.service = service;
	}

}
