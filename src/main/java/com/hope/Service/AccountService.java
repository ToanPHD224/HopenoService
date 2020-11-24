package com.hope.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.hope.entities.Account;

public interface AccountService extends CrudEnties<Account> {
	public Account getAccountByMail(String mail);
	public boolean registerAccount(Account ac);
	public Account createAccount();
	public String genPassWord(int lenght);
	public Account getAccount(String mail);
	public Page<Account> findAll(Pageable page);
	public Page<Account> findAllByMail(Pageable page,String mail);
	
}	
