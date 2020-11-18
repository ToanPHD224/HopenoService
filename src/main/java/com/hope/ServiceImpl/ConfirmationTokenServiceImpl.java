package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.hope.Repository.CofirmationTokenRepo;
import com.hope.Service.AccountService;
import com.hope.Service.ConfirmationTokenService;
import com.hope.entities.Account;
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

	@Override
	public ConfirmationToken getConfirmationTokenByToken(String token) {
		// TODO Auto-generated method stub
		return confrim.getConfirmationTokenByToken(token);
	}
	@Autowired
	private AccountService accountService;
	@Override
	public boolean confirmToken(String token) {
		ConfirmationToken c = getConfirmationTokenByToken(token);
		if (c == null) {
			return false;
		} else {
			Account ac = accountService.getById(c.getAccount().getId());
			if (ac.isStatus() == true) {
				return false;
			}
			ac.setStatus(true);
			accountService.update(ac);
			return true;
		}
	}
}
