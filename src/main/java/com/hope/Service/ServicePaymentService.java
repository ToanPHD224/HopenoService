package com.hope.Service;

import java.util.List;

import com.hope.entities.ServicePayment;

public interface ServicePaymentService extends CrudEnties<ServicePayment>  {
		public boolean sendAllPayment();
		public List<ServicePayment> isVailPayment(int month);
		
}
