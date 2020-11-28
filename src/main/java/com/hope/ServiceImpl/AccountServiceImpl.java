package com.hope.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.type.descriptor.java.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
				mailService.mailContent(ac,"To Cofirm you account please click that link "+c.getConfirmation_token(),"Complete Registation");
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

	@Override
	public String genPassWord(int lenght) {
		 String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[lenght];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< lenght ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      String s = new String(password);
	      return s;
	   }

	@Override
	public Account getAccount(String mail) {
		// TODO Auto-generated method stub
		return accountRepo.getAccount(mail);
	}

	@Override
	public Page<Account> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return accountRepo.findAll(page);
	}

	@Override
	public Page<Account> findAllByMail(Pageable page, String mail) {
		// TODO Auto-generated method stub
		return accountRepo.findAllByMail(page, mail);
	}

	@Override
	public String countAcount() {
		// TODO Auto-generated method stub
		return accountRepo.countAcount();
	}
	}


