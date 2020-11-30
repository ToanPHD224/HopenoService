package com.hope.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Random;

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

	@Override
	public List<SportField> getAllSportFiledVaildByService(long id, Date date, float start, float end) {
		// TODO Auto-generated method stub
		return spfr.getAllSportFiledVaildByService(id, date, start, end);
	}
	
	@Override
	public SportField getRandomSportFiled(List<SportField> list) {
		Random rand = new Random(); 
        SportField sp = list.get(rand.nextInt(list.size()));
		return sp; 
	}

	@Override
	public Integer countToltalSportFiledById(long id) {
		// TODO Auto-generated method stub
		return spfr.countToltalSportFiledById(id);
	}
}
