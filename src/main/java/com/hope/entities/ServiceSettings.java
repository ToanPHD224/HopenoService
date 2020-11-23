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

import lombok.Data;

@Entity
@Table(name = "service_settings")
@Data
public class ServiceSettings implements Serializable {
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
}
