package com.hope.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Service;
import com.hope.entities.ServiceFee;
@Repository
public interface ServiceFeeRepo extends JpaRepository<ServiceFee, Long> ,PagingAndSortingRepository<ServiceFee, Long> {
	@Query(value = "select * from service_fee where status = 1",nativeQuery = true)
	public List<ServiceFee> getAllServiceByStatus();
	
}
