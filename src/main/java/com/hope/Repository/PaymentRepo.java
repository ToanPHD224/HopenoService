package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
	@Query(value = "Select sum(servicesettings.amount) from  servicesettings where  servicesettings.time  >= :_start and servicesettings.time < :_end and servicesettings.service_id=:service",nativeQuery = true)
	public float getAmountByServiceAndTime(@Param("_start") float _start , @Param("_end") float _end , @Param("service") long service );
}
