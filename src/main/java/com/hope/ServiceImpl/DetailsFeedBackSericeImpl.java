package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.DetailsFeedBackRepo;
import com.hope.Service.DetailsFeedBackService;
import com.hope.entities.DetailsFeedBack;

@Service
public class DetailsFeedBackSericeImpl implements DetailsFeedBackService {
	@Autowired
	private DetailsFeedBackRepo dtl;
	@Override
	public List<DetailsFeedBack> findAll() {
		// TODO Auto-generated method stub
		return dtl.findAll();
	}

	@Override
	public void update(DetailsFeedBack enties) {
		// TODO Auto-generated method stub
		dtl.save(enties);
	}

	@Override
	public void save(DetailsFeedBack entites) {
		// TODO Auto-generated method stub
		dtl.save(entites);
	}

	@Override
	public DetailsFeedBack getById(long id) {
		// TODO Auto-generated method stub
		return dtl.getOne(id);
	}

	@Override
	public void delete(DetailsFeedBack entites) {
		// TODO Auto-generated method stub
		dtl.delete(entites);
	}
	
}
