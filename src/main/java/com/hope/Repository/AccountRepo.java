package com.hope.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.Account;
import com.hope.entities.Service;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> , PagingAndSortingRepository<Account, Long>{
	@Query(value ="Select * from account  where mail =:mail and status = 1"  ,  nativeQuery = true)
	public Account getAccountByMail(@Param("mail") String mail);	
	@Query(value ="Select * from account  where mail =:mail and status = 0"  ,  nativeQuery = true)
	public Account getAccount(@Param("mail") String mail);
	public Page<Account> findAllByMail(Pageable page,String mail);
	
}
