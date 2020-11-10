package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Ward;
@Repository
public interface WardRepo extends JpaRepository<Ward, Long> {

}
