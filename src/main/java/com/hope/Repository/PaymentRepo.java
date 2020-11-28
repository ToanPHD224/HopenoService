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
	@Query(value = "Select sum(service_settings.amount) from  service_settings where  service_settings.time  >= :_start and service_settings.time < :_end and service_settings.service_id=:service",nativeQuery = true)
	public float getAmountByServiceAndTime(@Param("_start") float _start , @Param("_end") float _end , @Param("service") long service );
	
	@Query(value = "select  payment.* from payment"
			+ " inner join sport_filed on payment.sport_field_id = sport_filed.id"
			+ " inner join service on sport_filed.service_id=service.id"
			+ " where (payment.date >= :startDate and payment.date < :endDate)  and service.id = :service",nativeQuery = true)
	public List<Payment> getAllPayMent(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
		 @Param("service")  long idservice);
	
}
