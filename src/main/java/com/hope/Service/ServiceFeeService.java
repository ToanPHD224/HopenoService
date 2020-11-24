package com.hope.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hope.entities.ServiceFee;

public interface ServiceFeeService extends CrudEnties<ServiceFee>  {
	Page<ServiceFee> getAllService(Pageable pageable);
}
