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

import lombok.Data;

@Entity
@Table(name = "sport_filed")
@Data
public class SportField implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(250)",length = 250)
	private String name;
	@Column(name = "type")
	private int type;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	@OneToMany(mappedBy = "sportfield",cascade = CascadeType.ALL)
	private Set<Payment> payment;
	@Column(name = "status")
	private boolean status;
}
