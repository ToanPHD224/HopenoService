package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.DistricsRepo;
import com.hope.Service.DistricsService;
import com.hope.entities.Districs;
@Service
public class DistricsServiceImpl implements DistricsService {
	@Autowired
	private DistricsRepo districsRepo;
	@Override
	public List<Districs> findAll() {
		// TODO Auto-generated method stub
		return districsRepo.findAll();
	}

	@Override
	public void update(Districs enties) {
		// TODO Auto-generated method stub
		districsRepo.save(enties);
		
	}

	@Override
	public void save(Districs entites) {
		districsRepo.save(entites);
		
	}

	@Override
	public Districs getById(long id) {
		// TODO Auto-generated method stub
		return districsRepo.getOne(id);
	}

	@Override
	public void delete(Districs entites) {
		districsRepo.delete(entites);
		
	}

}
