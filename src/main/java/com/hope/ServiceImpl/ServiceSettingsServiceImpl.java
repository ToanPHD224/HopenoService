package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.ServiceSettingRepo;
import com.hope.Service.ServiceSettingsService;
import com.hope.entities.ServiceSettings;
@Service
public class ServiceSettingsServiceImpl implements ServiceSettingsService {
	@Autowired
	private ServiceSettingRepo serviceSetting;
	@Override
	public List<ServiceSettings> findAll() {
		// TODO Auto-generated method stub
		return serviceSetting.findAll();
	}

	@Override
	public void update(ServiceSettings enties) {
		// TODO Auto-generated method stub
		serviceSetting.save(enties);
	}

	@Override
	public void save(ServiceSettings entites) {
		// TODO Auto-generated method stub
		serviceSetting.save(entites);
	}

	@Override
	public ServiceSettings getById(long id) {
		// TODO Auto-generated method stub
		return serviceSetting.getOne(id);
	}

	@Override
	public void delete(ServiceSettings entites) {
		// TODO Auto-generated method stub
		serviceSetting.delete(entites);
	}

}
