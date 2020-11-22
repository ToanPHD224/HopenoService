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

@Entity
@Table(name = "districs")
public class Districs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar")
	private String name;
	@OneToMany(mappedBy = "districs",cascade = CascadeType.ALL)
	private Set<Ward> ward;
	
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
	public Set<Ward> getWard() {
		return ward;
	}
	public void setWard(Set<Ward> ward) {
		this.ward = ward;
	}
	public Districs() {}
	public Districs(String name, Set<Ward> ward) {
		super();
		this.name = name;
		this.ward = ward;
	}
	public Districs(long id, String name, Set<Ward> ward) {
		super();
		this.id = id;
		this.name = name;
		this.ward = ward;
	}
	
	
	
}
