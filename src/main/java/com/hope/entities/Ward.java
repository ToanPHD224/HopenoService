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

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "ward")
@Data
@AllArgsConstructor
public class Ward implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",columnDefinition = "nvarchar(250)")
	private String name;
	@ManyToOne
	@JoinColumn(name = "districs_id")
	private Districs districs;
	@OneToMany(mappedBy = "ward",cascade = CascadeType.ALL)
	private Set<Service> service;
	public Ward() {
		// TODO Auto-generated constructor stub
	}
}
