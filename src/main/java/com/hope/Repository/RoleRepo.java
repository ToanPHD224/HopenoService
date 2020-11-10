package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Long>  {
	
}
