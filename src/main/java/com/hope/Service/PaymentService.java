package com.hope.Service;

import java.util.Date;
import java.util.List;

import com.hope.entities.Payment;

public interface PaymentService extends CrudEnties<Payment> {
	public float getAmountByServiceAndTime(float _start, float duration, long service);


	public List<Payment> getAllPayMent(Date startDate, Date endDate, long idservice);
}