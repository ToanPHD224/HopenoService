package com.hope.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.hope.Service.AccountService;
import com.hope.entities.Account;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AccountService acsv;
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account ac = acsv.getAccountByMail(username);
		System.out.println(ac.getRole().getName());
		if(ac==null)
		{
			throw new UsernameNotFoundException("Not found");
			
		}
		 Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		 grantedAuthorities.add(new SimpleGrantedAuthority(ac.getRole().getName()));
		 System.out.println(grantedAuthorities.toString());
		return new org.springframework.security.core.userdetails.User(ac.getMail(),ac.getPassword(),grantedAuthorities);
	}

}

