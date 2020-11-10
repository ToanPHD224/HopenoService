package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.ConfirmationToken;
@Repository
public interface CofirmationTokenRepo extends JpaRepository<ConfirmationToken, Long> {
	@Query(value = "Select * from confirmationtoken where confirmation_token =: token",nativeQuery = true)
	public ConfirmationToken getConfirmationTokenByToken(@Param("token") String token);

}
