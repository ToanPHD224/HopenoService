package com.hope.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.hope.entities.Service;

public interface ServiceService extends CrudEnties<Service>  {
	public List<Service> getAllServiceFromDateAndTime(Date date ,float start , float end );
	public List<Service> getAllServiceByDateTimeAndDistric(String quan,Date date ,float start,float end);
	public List<Service> getAllServiceForArtibiue(String quan,String date ,float start,float end);
	public List<Service> getAllRegistationServive(Date date);
	public Page<Service> findAll(int page);
	public Page<Service> findAllByRegistedAtAndStatus(Pageable page,Date date,int status);
	public List<Service> findAllByStatus(int status);
	public int registationService(String mail,long id);
	public int declineService(long id,String mail);
	public List<Service> findAllByMail(String mail,int status);
	public List<Service> findAllByStatusAndId(int  status, long id);
	public String getTotalBook( long id);
	public String getTotalAmount(long id);
	public int getToltalService(long id);
	public String getAVGFee(long id);
	public Service getService(long id);
	public boolean getStatusOffService(long id);
	public List<Service> findAllServiceAceptandActive(); 
	public List<Service> findAllServiceAceptandActive(long id); 
	public String countRegisterForm(Date date);
	
}
