package com.hope.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.hope.entities.ServicePayment;

public interface ServicePaymentService extends CrudEnties<ServicePayment>  {
		public boolean sendAllPayment();
		public List<ServicePayment> isVailPayment(Date date);
		public String countBook(int month);
		public String countFee(int month);
		public Date nearestPaymentDate();
		public String[] getDate();
		public List<ServicePayment> listServicePayment(int month);
}
