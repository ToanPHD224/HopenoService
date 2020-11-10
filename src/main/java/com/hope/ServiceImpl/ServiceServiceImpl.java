package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hope.Repository.ServiceRepo;
import com.hope.Service.ServiceService;
import com.hope.entities.Service;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
	@Autowired
	private ServiceRepo servicerepo;
	@Override
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		return servicerepo.findAll();
	}

	@Override
	public void update(Service enties) {
		// TODO Auto-generated method stub
		servicerepo.save(enties);
	}

	@Override
	public void save(Service entites) {
		// TODO Auto-generated method stub
		servicerepo.save(entites);
	}

	@Override
	public Service getById(long id) {
		// TODO Auto-generated method stub
		return servicerepo.getOne(id);
	}

	@Override
	public void delete(Service entites) {
		// TODO Auto-generated method stub
		servicerepo.delete(entites);;
	}

}
