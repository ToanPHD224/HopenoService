package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.SportFieldRepo;
import com.hope.Service.SportFieldService;
import com.hope.entities.SportField;
@Service
public class SportFieldServiceImpl implements SportFieldService{
	@Autowired
	private SportFieldRepo spfr;
	@Override
	public List<SportField> findAll() {
		// TODO Auto-generated method stub
		return spfr.findAll();
	}

	@Override
	public void update(SportField enties) {
		// TODO Auto-generated method stub
		spfr.save(enties);
	}

	@Override
	public void save(SportField entites) {
		// TODO Auto-generated method stub
		spfr.save(entites);
	}

	@Override
	public SportField getById(long id) {
		// TODO Auto-generated method stub
		return spfr.getOne(id);
	}

	@Override
	public void delete(SportField entites) {
		// TODO Auto-generated method stub
		spfr.delete(entites);
	}

}
