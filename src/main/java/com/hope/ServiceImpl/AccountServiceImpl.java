package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.AccountRepo;
import com.hope.Service.AccountService;
import com.hope.entities.Account;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
		return accountRepo.findAll();
	} 

	@Override
	public void update(Account enties) {
		// TODO Auto-generated method stub
		accountRepo.save(enties);
		
	}

	@Override
	public void save(Account entites) {
		accountRepo.save(entites);
		
	}

	@Override
	public Account getById(long id) {
		// TODO Auto-generated method stub
		return null;
		return accountRepo.getOne(id);
	}

	@Override
	public void delete(Account entites) {
		accountRepo.delete(entites);
		
	}

}
