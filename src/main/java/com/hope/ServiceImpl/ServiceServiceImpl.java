package com.hope.ServiceImpl;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.hope.Repository.ServiceRepo;
import com.hope.Service.DateHelperService;
import com.hope.Service.ServiceService;
import com.hope.entities.Service;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
	@Autowired
	private ServiceRepo servicerepo;

	@Override
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		return servicerepo.findAll();
	}

	@Override
	public void update(Service enties) {
		// TODO Auto-generated method stub
		servicerepo.save(enties);
	}

	@Override
	public void save(Service entites) {
		// TODO Auto-generated method stub
		servicerepo.save(entites);
	}

	@Override
	public Service getById(long id) {
		// TODO Auto-generated method stub
		return servicerepo.getOne(id);
	}

	@Override
	public void delete(Service entites) {
		// TODO Auto-generated method stub
		servicerepo.delete(entites);
		;
	}

	@Override
	public List<Service> getAllServiceFromDateAndTime(Date date, float start, float end) {
		// TODO Auto-generated method stub
		System.out.println(date);
		return servicerepo.getAllServiceFromDateAndTime(date, start, end);
	}

	@Override
	public List<Service> getAllServiceByDateTimeAndDistric(String quan, Date date, float start, float end) {
		// TODO Auto-generated method stub
		SimpleDateFormat smf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(smf.format(date));
		return servicerepo.getAllServiceByDateTimeAndDistric(quan, date, start, end);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@Autowired
	private DateHelperService dateHelpService;

	@Override
	public List<Service> getAllServiceForArtibiue(String quan, String date, float start, float end) {
		List<Service> listService = getAllServiceFromDateAndTime(dateHelpService.convetDatetoSql(date), start, end);;
		if (quan.length() > 0) {
			listService = getAllServiceByDateTimeAndDistric(quan, dateHelpService.convetDatetoSql(date), start, end);
		} 
		return listService;
	}

	@Override
	public List<Service> getAllRegistationServive(Date date) {
		// TODO Auto-generated method stub
		return servicerepo.getAllRegistationServive(date);
	}

	@Override
	public Page<Service> findAll(int page) {
		org.springframework.data.domain.Pageable pageable = PageRequest.of(page, 2);
		return servicerepo.findAll(pageable);
	}

	@Override
	public Page<Service> findAllByRegistedAt(org.springframework.data.domain.Pageable page, Date date) {
		// TODO Auto-generated method stub
		return servicerepo.findAllByRegistedAt(page, date);
	}

}
