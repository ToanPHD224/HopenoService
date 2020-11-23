package com.hope.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "service_fee")
@Data
public class ServiceFee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "booking_fee")
	private float booking_Fee;
	@Column(name = "name",columnDefinition = "nvarchar(250)" ,length = 250)
	private String name;
	@OneToMany(mappedBy = "servicefee",cascade = CascadeType.ALL)
	private Set<Service> service;
	@Column(name = "status")
	private boolean status;

}
