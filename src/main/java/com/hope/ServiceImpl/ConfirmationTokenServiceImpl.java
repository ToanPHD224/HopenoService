package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.CofirmationTokenRepo;
import com.hope.Service.ConfirmationTokenService;
import com.hope.entities.ConfirmationToken;
@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
	
	@Autowired
	private CofirmationTokenRepo confrim;
	
	@Override
	public List<ConfirmationToken> findAll() {
		// TODO Auto-generated method stub
		return confrim.findAll();
	}

	@Override
	public void update(ConfirmationToken enties) {
		confrim.save(enties);
		
	}

	@Override
	public void save(ConfirmationToken entites) {
		confrim.save(entites);
		
	}

	@Override
	public ConfirmationToken getById(long id) {
		// TODO Auto-generated method stub
		return confrim.getOne(id);
	}

	@Override
	public void delete(ConfirmationToken entites) {
		confrim.delete(entites);
		
	}

}
