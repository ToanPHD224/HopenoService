package com.hope.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
	@Query(value = "Select sum(servicesettings.amount) from  servicesettings where  servicesettings.time  >= :_start and servicesettings.time < :_end and servicesettings.service_id=:service",nativeQuery = true)
	public float getAmountByServiceAndTime(@Param("_start") float _start , @Param("_end") float _end , @Param("service") long service );
	@Query(value = "select * from payment.* where payment.date between :starDate and :endDate " , nativeQuery = true)
	public List<Payment> getAllPaymentByMonth(@Param("starDate") Date startdate ,@Param("endDate") Date enddate );
	
	@Query(value = "select  payment.* from payment"
			+ " inner join sportfiled on payment.sportfield_id = sportfiled.id"
			+ " inner join service on sportfiled.service_id=service.id"
			+ " where payment.date between :startDate and :endDate and service.id = :service",nativeQuery = true)
	public List<Payment> getAllPayMent(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
		 @Param("service")  long idservice);
	

}
