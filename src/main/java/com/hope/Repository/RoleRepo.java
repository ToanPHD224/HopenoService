package com.hope.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Role;
import com.hope.entities.Service;
@Repository
public interface RoleRepo extends JpaRepository<Role, Long>  {
	
}
