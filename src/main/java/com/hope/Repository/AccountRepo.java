package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	
}
