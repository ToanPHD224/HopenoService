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

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "amount")
	private float amount;
	@Column(name = "create_date")
	private Date create_date;
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
	@JoinColumn(name = "sportfield_id")
	private SportField sportfield;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float get_start() {
		return _start;
	}
	public void set_start(float _start) {
		this._start = _start;
	}
	public float get_end() {
		return _end;
	}
	public void set_end(float _end) {
		this._end = _end;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public SportField getSportfield() {
		return sportfield;
	}
	public void setSportfield(SportField sportfield) {
		this.sportfield = sportfield;
	}
	public Payment() {
		// 0 is dang cho , 1 da xac nhan , 2 la huy bo
		this.status =0;
	}
	public Payment(long id, float amount, Date create_date, int status, float _start, float _end, Date date,
			Account account, SportField sportfield) {
		super();
		this.id = id;
		this.amount = amount;
		this.create_date = create_date;
		this.status = status;
		this._start = _start;
		this._end = _end;
		this.date = date;
		this.account = account;
		this.sportfield = sportfield;
	}
	public Payment(float amount, Date create_date, int status, float _start, float _end, Date date, Account account,
			SportField sportfield) {
		super();
		this.amount = amount;
		this.create_date = create_date;
		this.status = status;
		this._start = _start;
		this._end = _end;
		this.date = date;
		this.account = account;
		this.sportfield = sportfield;
	}
	
	
}
