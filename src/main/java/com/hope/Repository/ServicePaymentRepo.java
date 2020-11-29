package com.hope.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hope.entities.ServicePayment;

public interface ServicePaymentRepo extends JpaRepository<ServicePayment, Long>  {
	
	@Query(value = "select * from service_payment where service_payment.payment_date = :date ",nativeQuery = true)
	public List<ServicePayment> isVailPayment(@Param("date") Date start_date);
	@Query(value = "select sum(service_payment.totalbook) from service_payment where service_payment.payment_date between :start_date and :end_date ",nativeQuery = true)
	public String countBook(@Param("start_date") Date start_date , @Param("end_date") Date endDate);
	@Query(value = "select sum(service_payment.total_fee) from service_payment where service_payment.payment_date between :start_date and :end_date ",nativeQuery = true)	
	public String countFee(@Param("start_date") Date start_date , @Param("end_date") Date endDate);
	@Query(value = "select max(service_payment.payment_date) from service_payment",nativeQuery = true)
	public Date nearestPaymentDate();
	@Query(value = "select * from service_payment where service_payment.payment_date between :start_date and :end_date and status=0 and total_fee>0",nativeQuery = true)
	public List<ServicePayment> listServicePayment(@Param("start_date") Date start_date , @Param("end_date") Date end_date);
	
}
