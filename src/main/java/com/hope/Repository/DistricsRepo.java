package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Districs;
@Repository
public interface DistricsRepo extends JpaRepository<Districs, Long>  {

}
