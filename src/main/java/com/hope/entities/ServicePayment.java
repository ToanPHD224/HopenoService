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
@Table(name = "servicepayment")
public class ServicePayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "totalbook")
	private int totalBook;
	@ManyToOne
	@JoinColumn(name = "idservice")
	private Service service;
	@Column(name = "nametype")
	private String name;
	@Column(name = "toltalpay")
	private float totalPay;
	@Column(name = "totalFee")
	private float totalFee;
	@Column(name = "month")
	private float month;
	@Column(name = "status")
	private boolean status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTotalBook() {
		return totalBook;
	}
	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public float getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(float totalPay) {
		this.totalPay = totalPay;
	}
	public float getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(float totalFee) {
		this.totalFee = totalFee;
	}
	public float getMonth() {
		return month;
	}
	public void setMonth(float month) {
		this.month = month;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ServicePayment(long id, int totalBook, Service service, float totalPay, float totalFee,
			float month, boolean status) {
		super();
		this.id = id;
		this.totalBook = totalBook;
		this.service = service;
		this.totalPay = totalPay;
		this.totalFee = totalFee;
		this.month = month;
		this.status = status;
	}
	public ServicePayment(int totalBook, Service service, float totalPay, float totalFee,
			float month, boolean status) {
		super();
		this.totalBook = totalBook;
		this.service = service;
		this.totalPay = totalPay;
		this.totalFee = totalFee;
		this.month = month;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ServicePayment(int totalBook, Service service, String name, float totalPay, float totalFee, float month,
			boolean status) {
		super();
		this.totalBook = totalBook;
		this.service = service;
		this.name = name;
		this.totalPay = totalPay;
		this.totalFee = totalFee;
		this.month = month;
		this.status = status;
	}
	public ServicePayment() {
		super();
	}
	
		
}
