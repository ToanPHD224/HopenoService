package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.FeedBackRepo;
import com.hope.Service.FeedBackService;
import com.hope.entities.FeedBack;
@Service
public class FeedBackServiceImpl implements FeedBackService {
	@Autowired
	private FeedBackRepo fbrepo;
	@Override
	public List<FeedBack> findAll() {
		// TODO Auto-generated method stub
		return fbrepo.findAll();
	}

	@Override
	public void update(FeedBack enties) {
		// TODO Auto-generated method stub
		fbrepo.save(enties);
		
	}

	@Override
	public void save(FeedBack entites) {
		// TODO Auto-generated method stub
		fbrepo.save(entites);
	}

	@Override
	public FeedBack getById(long id) {
		// TODO Auto-generated method stub
		return fbrepo.getOne(id);
	}

	@Override
	public void delete(FeedBack entites) {
		// TODO Auto-generated method stub
		fbrepo.delete(entites);
	}

}
