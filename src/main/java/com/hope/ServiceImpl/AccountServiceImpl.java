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
		return accountRepo.findAll();
	} 

	@Override
	public void update(Account enties) {
		accountRepo.save(enties);
		
	}

	@Override
	public void save(Account entites) {
		accountRepo.save(entites);
		
	}

	@Override
	public Account getById(long id) {
		
		return accountRepo.getOne(id);
	}

	@Override
	public void delete(Account entites) {
		accountRepo.delete(entites);
		
	}

	@Override
	public Account getAccountByMail(String mail) {
		// TODO Auto-generated method stub
		return accountRepo.getAccountByMail(mail);
	}

}
