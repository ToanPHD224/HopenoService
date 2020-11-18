package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	@Query(value ="Select * from account  where mail =:mail and status = 1"  ,  nativeQuery = true)
	public Account getAccountByMail(@Param("mail") String mail);
}
