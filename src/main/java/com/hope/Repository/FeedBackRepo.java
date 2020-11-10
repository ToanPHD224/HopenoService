package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.FeedBack;
@Repository
public interface FeedBackRepo extends JpaRepository<FeedBack, Long> {

}
