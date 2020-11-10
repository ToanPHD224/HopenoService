package com.hope.Service;
import com.hope.entities.Account;

public interface AccountService extends CrudEnties<Account> {
	public Account getAccountByMail(String mail);
}	
