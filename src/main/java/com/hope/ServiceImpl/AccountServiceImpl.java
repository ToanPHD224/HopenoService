package com.hope.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.type.descriptor.java.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.hope.Repository.AccountRepo;
import com.hope.Service.AccountService;
import com.hope.Service.ConfirmationTokenService;
import com.hope.Service.DateHelperService;
import com.hope.Service.MailService;
import com.hope.Service.RoleService;
import com.hope.entities.Account;
import com.hope.entities.ConfirmationToken;

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

	@Autowired
	private BCryptPasswordEncoder encode;

	@Override
	public void save(Account entites) {
		entites.setPassword(encode.encode(entites.getPassword()));
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


	@Autowired
	private RoleService roleService;
	@Autowired
	private ConfirmationTokenService confirmationToken;
	@Autowired
	private MailService mailService;
	@Autowired
	private DateHelperService dateHelper;
	@Override
	public boolean registerAccount( Account ac) {
		Account newAc = getAccountByMail(ac.getMail());
		if (newAc != null) {
			return false;
		} else {
			try {
				save(ac);
				ConfirmationToken c = new ConfirmationToken(ac);
				confirmationToken.save(c);
				mailService.mailContent(ac, c);
				return true;
			} catch (Exception e) {
				return false;
			}

		}

	}
	
	@Override
	public Account createAccount() {
		Account ac = new Account();
		ac.setRole(roleService.getById(3));
		ac.setStatus(false);
		 LocalDateTime lt  = LocalDateTime.now(); 
		ac.setCreated_at(new Date());
		return ac;
	}

}
