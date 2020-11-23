package com.hope.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "confirmationtoken")
public class ConfirmationToken implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	@Column(name = "confirmation_token")
	private String confirmation_token;
	@Column(name = "createdDate")
	private Date createdDate;
	@OneToOne 
	@JoinColumn(name = "account_id")
	private Account account;
	public ConfirmationToken() {}
	public ConfirmationToken(Account account) {
		super();
		this.account = account;
		createdDate = new Date();
		confirmation_token = UUID.randomUUID().toString();
	}
	
}
