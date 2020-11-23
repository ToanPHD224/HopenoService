package com.hope.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hope.entities.ServicePayment;

public interface ServicePaymentRepo extends JpaRepository<ServicePayment, Long>  {
	
	@Query(value = "select * from service_payment where month =:month",nativeQuery = true)
	public List<ServicePayment> isVailPayment(@Param("month") int month);

}
