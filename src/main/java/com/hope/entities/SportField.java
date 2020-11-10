package com.hope.entities;

import java.io.Serializable;
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
@Table(name = "sportfiled")
public class SportField implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private int type;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	@OneToMany(mappedBy = "sportfield",cascade = CascadeType.ALL)
	private Set<Payment> payment;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Set<Payment> getPayment() {
		return payment;
	}
	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	public SportField(long id, String name, int type, Service service, Set<Payment> payment) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.service = service;
		this.payment = payment;
	}
	public SportField(String name, int type, Service service, Set<Payment> payment) {
		super();
		this.name = name;
		this.type = type;
		this.service = service;
		this.payment = payment;
	} 
	public SportField() {}

}
