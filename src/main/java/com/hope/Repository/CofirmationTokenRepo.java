package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.ConfirmationToken;
@Repository
public interface CofirmationTokenRepo extends JpaRepository<ConfirmationToken, Long> {
	

}
