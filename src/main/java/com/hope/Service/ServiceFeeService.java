package com.hope.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hope.entities.ServiceFee;

public interface ServiceFeeService extends CrudEnties<ServiceFee>  {
	Page<ServiceFee> getAllService(Pageable pageable);
	public List<ServiceFee> getAllServiceByStatus();
}
