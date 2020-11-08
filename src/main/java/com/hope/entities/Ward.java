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
@Table(name = "ward")
public class Ward {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "districs_id")
	private Districs districs;
	@OneToMany(mappedBy = "ward",cascade = CascadeType.ALL)
	private Set<Service> service;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Districs getDistrics() {
		return districs;
	}
	public void setDistrics(Districs districs) {
		this.districs = districs;
	}
	public Set<Service> getService() {
		return service;
	}
	public void setService(Set<Service> service) {
		this.service = service;
	}
	public Ward(long id, String name, Districs districs, Set<Service> service) {
		super();
		this.id = id;
		this.name = name;
		this.districs = districs;
		this.service = service;
	}
	public Ward(String name, Districs districs, Set<Service> service) {
		super();
		this.name = name;
		this.districs = districs;
		this.service = service;
	}
	public Ward() {}
	
}
