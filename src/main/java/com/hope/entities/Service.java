package com.hope.entities;

import java.io.Serializable;
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
public class Service implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private long id;
	@Column(name = "address",columnDefinition = "nvarchar")
	private String address;
	@Column(name = "content",columnDefinition = "nvarchar")
	private String content;
	@Column(name = "image",columnDefinition = "nvarchar")
	private String image;
	@Column(name = "additionalfee")
	private float addtionalfee;
	@Column(name = "name",columnDefinition = "nvarchar")
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Service() {}

	public Service(long id, String address, String content, String image, float addtionalfee, String name,
			boolean status, Account account, ServiceFee servicefee, Ward ward, Set<ServiceSettings> servicesettings,
			Set<FeedBack> feedback, Set<SportField> sportFields) {
		super();
		this.id = id;
		this.address = address;
		this.content = content;
		this.image = image;
		this.addtionalfee = addtionalfee;
		this.name = name;
		this.status = status;
		this.account = account;
		this.servicefee = servicefee;
		this.ward = ward;
		this.servicesettings = servicesettings;
		this.feedback = feedback;
		this.sportFields = sportFields;
	}

	public Service(String address, String content, String image, float addtionalfee, String name, boolean status,
			Account account, ServiceFee servicefee, Ward ward, Set<ServiceSettings> servicesettings,
			Set<FeedBack> feedback, Set<SportField> sportFields) {
		super();
		this.address = address;
		this.content = content;
		this.image = image;
		this.addtionalfee = addtionalfee;
		this.name = name;
		this.status = status;
		this.account = account;
		this.servicefee = servicefee;
		this.ward = ward;
		this.servicesettings = servicesettings;
		this.feedback = feedback;
		this.sportFields = sportFields;
	}
	
	
	
}
