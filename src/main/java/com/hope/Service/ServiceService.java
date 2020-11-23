package com.hope.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.ModelMap;

import com.hope.entities.Service;

public interface ServiceService extends CrudEnties<Service>  {
	public List<Service> getAllServiceFromDateAndTime(Date date ,float start , float end );
	public List<Service> getAllServiceByDateTimeAndDistric(String quan,Date date ,float start,float end);
	public List<Service> getAllServiceForArtibiue(String quan,String date ,float start,float end);
	public List<Service> getAllRegistationServive(Date date);
	public Page<Service> findAll(int page);
	public Page<Service> findAllByRegistedAtAndStatus(Pageable page,Date date,boolean status);
	public List<Service> findAllByStatus(boolean status);
	public int registationService(String mail,long id);
}
