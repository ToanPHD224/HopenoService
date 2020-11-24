package com.hope.entities;

import java.io.Serializable;
import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "service")
@Data
@AllArgsConstructor
public class Service implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private long id;
	@Column(name = "address",columnDefinition = "nvarchar(250)",length = 250)
	private String address;
	@Column(name = "content",columnDefinition = "nvarchar(250)",length = 250)
	private String content;
	@Column(name = "image")
	private String image;
	@Column(name = "additional_fee")
	private float addtionalfee;
	@Column(name = "name",columnDefinition = "nvarchar(250)",length = 250)
	private String name;
	@Column(name = "email")
	private String mail;
	@Column(name = "viewer")
	private float viewer;
	@Column(name = "status")
	private boolean status;
	@Column(name = "banned")
	private boolean banned;
	@Column(name = "created_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@Column(name = "registered_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registeredAt;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "service_fee_id")
	private ServiceFee servicefee;
	@ManyToOne
	@JoinColumn(name = "ward_id")
	private Ward ward;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<ServiceSettings> servicesettings;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<FeedBack> feedback;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<SportField> sportFields;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<ServicePayment> servicePayment;
	public Service() {}
}
