package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.DetailsFeedBack;
@Repository
public interface DetailsFeedBackRepo extends JpaRepository<DetailsFeedBack, Long> {
	
}
