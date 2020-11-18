package com.hope.DTO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import com.hope.Service.PaymentService;
import com.hope.entities.Service;
@org.springframework.stereotype.Service
public class BookDTO {
	private Service service;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private float start;
	private float duration;
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getStart() {
		return start;
	}

	public void setStart(float start) {
		this.start = start;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}
	public BookDTO(Service service, Date date, float start, float duration) {
		super();
		this.service = service;
		this.date = date;
		this.start = start;
		this.duration = duration;
	}

	public BookDTO() {
		
	}


}
