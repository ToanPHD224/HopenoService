package com.hope.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Page<FeedBack> findAllByTypeAndCreatedAt(int type, Date createdat, Pageable page) {
		// TODO Auto-generated method stub
		return fbrepo.findAllByTypeAndCreatedAt(type, createdat, page);
	}

	@Override
	public String getAVGRating(long id) {
		// TODO Auto-generated method stub
		return fbrepo.getAVGRating(id);
	}

	@Override
	public List<FeedBack> getTopFiveFeedBackByService(long id) {
		// TODO Auto-generated method stub
		return fbrepo.getTopFiveFeedBackByService(id);
	}

}
