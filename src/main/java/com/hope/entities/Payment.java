package com.hope.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
public class Payment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "amount")
	private float amount;
	@Column(name = "created_date")
	private Date created_date;
	@Column(name = "status")
	private int status;
	@Column(name = "_start")
	private float _start;
	@Column(name = "_end")
	private float _end;
	@Column(name = "date")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "sport_field_id")
	private SportField sportfield;
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
}
