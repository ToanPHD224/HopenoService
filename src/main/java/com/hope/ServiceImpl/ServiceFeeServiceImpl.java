package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.ServiceFeeRepo;
import com.hope.Service.ServiceFeeService;
import com.hope.entities.ServiceFee;

@Service
public class ServiceFeeServiceImpl implements ServiceFeeService {
	@Autowired
	private ServiceFeeRepo servicefeerepo;

	@Override
	public List<ServiceFee> findAll() {
		// TODO Auto-generated method stub
		return servicefeerepo.findAll();
	}

	@Override
	public void update(ServiceFee enties) {
		servicefeerepo.save(enties);
		
	}

	@Override
	public void save(ServiceFee entites) {
		// TODO Auto-generated method stub
		servicefeerepo.save(entites);
	}

	@Override
	public ServiceFee getById(long id) {
		// TODO Auto-generated method stub
		return servicefeerepo.getOne(id);
	}

	@Override
	public void delete(ServiceFee entites) {
		// TODO Auto-generated method stub
		servicefeerepo.delete(entites);
	}
	


}
