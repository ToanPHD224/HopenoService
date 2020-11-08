package com.hope.entities;

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
@Table(name = "service")
public class Service {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private long id;
	@Column(name = "address")
	private String address;
	@Column(name = "additionalfee")
	private float addtionalfee;
	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private boolean status;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "servicefee_id")
	private ServiceFee servicefee;
	@ManyToOne
	@JoinColumn(name = "ward_id")
	private Ward ward;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<ServiceSettings> servicesettings;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<ServiceOverView> serviceoverview;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<FeedBack> feedback;
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
	private Set<SportField> sportFields;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getAddtionalfee() {
		return addtionalfee;
	}
	public void setAddtionalfee(float addtionalfee) {
		this.addtionalfee = addtionalfee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public ServiceFee getServicefee() {
		return servicefee;
	}
	public void setServicefee(ServiceFee servicefee) {
		this.servicefee = servicefee;
	}
	public Ward getWard() {
		return ward;
	}
	public void setWard(Ward ward) {
		this.ward = ward;
	}
	public Set<ServiceSettings> getServicesettings() {
		return servicesettings;
	}
	public void setServicesettings(Set<ServiceSettings> servicesettings) {
		this.servicesettings = servicesettings;
	}
	public Set<ServiceOverView> getServiceoverview() {
		return serviceoverview;
	}
	public void setServiceoverview(Set<ServiceOverView> serviceoverview) {
		this.serviceoverview = serviceoverview;
	}
	public Set<FeedBack> getFeedback() {
		return feedback;
	}
	public void setFeedback(Set<FeedBack> feedback) {
		this.feedback = feedback;
	}
	public Set<SportField> getSportFields() {
		return sportFields;
	}
	public void setSportFields(Set<SportField> sportFields) {
		this.sportFields = sportFields;
	}
	public Service(long id, String address, float addtionalfee, String name, boolean status, Account account,
			ServiceFee servicefee, Ward ward, Set<ServiceSettings> servicesettings,
			Set<ServiceOverView> serviceoverview, Set<FeedBack> feedback, Set<SportField> sportFields) {
		super();
		this.id = id;
		this.address = address;
		this.addtionalfee = addtionalfee;
		this.name = name;
		this.status = status;
		this.account = account;
		this.servicefee = servicefee;
		this.ward = ward;
		this.servicesettings = servicesettings;
		this.serviceoverview = serviceoverview;
		this.feedback = feedback;
		this.sportFields = sportFields;
	}
	public Service(String address, float addtionalfee, String name, boolean status, Account account,
			ServiceFee servicefee, Ward ward, Set<ServiceSettings> servicesettings,
			Set<ServiceOverView> serviceoverview, Set<FeedBack> feedback, Set<SportField> sportFields) {
		super();
		this.address = address;
		this.addtionalfee = addtionalfee;
		this.name = name;
		this.status = status;
		this.account = account;
		this.servicefee = servicefee;
		this.ward = ward;
		this.servicesettings = servicesettings;
		this.serviceoverview = serviceoverview;
		this.feedback = feedback;
		this.sportFields = sportFields;
	}
	public Service() {}
	
	
	
}
