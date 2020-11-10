package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.ServiceFee;
@Repository
public interface ServiceFeeRepo extends JpaRepository<ServiceFee, Long>  {

}
