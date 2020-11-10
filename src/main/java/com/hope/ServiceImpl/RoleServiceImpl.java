package com.hope.ServiceImpl;

import java.util.List;import javax.persistence.Embeddable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.RoleRepo;
import com.hope.Service.RoleService;
import com.hope.entities.Role;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepo roleRp;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRp.findAll();
	}

	@Override
	public void update(Role enties) {
		// TODO Auto-generated method stub
		roleRp.save(enties);
	}

	@Override
	public void save(Role entites) {
		// TODO Auto-generated method stub
		roleRp.save(entites);
	}

	@Override
	public Role getById(long id) {
		// TODO Auto-generated method stub
		return roleRp.getOne(id);
	}

	@Override
	public void delete(Role entites) {
		// TODO Auto-generated method stub
		roleRp.delete(entites);
		
	}

}
