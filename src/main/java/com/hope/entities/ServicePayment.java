package com.hope.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "service_payment")
@Data
public class ServicePayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "totalbook")
	private int totalBook;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	@Column(name = "name",columnDefinition = "nvarchar(250)",length = 250)
	private String name;
	@Column(name = "toltal_pay")
	private float totalPay;
	@Column(name = "total_fee")
	private float totalFee;
	@Column(name = "month")
	private float month;
	@Column(name = "status")
	private boolean status;
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
	
		
}
