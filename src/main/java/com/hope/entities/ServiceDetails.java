package com.hope.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceDetails {
	private Service service;
	private float avgRating;
	private float avgFee;
	private Ward ward;
	private Districs districs;
	private int sportFiled;
	public ServiceDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
}
