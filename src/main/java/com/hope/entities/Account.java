package com.hope.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account")
public class Account implements Serializable {
	/**
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "address",columnDefinition = "nvarchar(250)",length = 250)
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	@Column(name = "mail")
	private String mail;
	@Column(name = "name",columnDefinition = "nvarchar(250)",length = 250)
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private boolean status =false;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<Service> service;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<Payment> payment;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<FeedBack> feedback;
	@Column(name = "banned")
	private boolean banned;
	public Account() {}
}
