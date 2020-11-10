package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.WardRepo;
import com.hope.Service.WardService;
import com.hope.entities.Ward;
@Service
public class WardServiceImpl implements WardService {
	@Autowired
	private WardRepo ward;
	@Override
	public List<Ward> findAll() {
		// TODO Auto-generated method stub
		return ward.findAll();
	}

	@Override
	public void update(Ward enties) {
		// TODO Auto-generated method stub
		ward.save(enties);
	}

	@Override
	public void save(Ward entites) {
		// TODO Auto-generated method stub
		ward.save(entites);
	}

	@Override
	public Ward getById(long id) {
		// TODO Auto-generated method stub
		return ward.getOne(id);
	}

	@Override
	public void delete(Ward entites) {
		// TODO Auto-generated method stub
		ward.delete(entites);
	}

}
