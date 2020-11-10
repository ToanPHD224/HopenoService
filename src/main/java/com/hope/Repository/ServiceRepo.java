package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Service;
@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {

}
