package com.hope.ServiceImpl;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.hope.Service.AccountService;
import com.hope.Service.ConfirmationTokenService;
import com.hope.Service.DateHelperService;
import com.hope.Service.MailService;
import com.hope.Service.RoleService;
import com.hope.Service.ServiceService;
import com.hope.entities.Account;
import com.hope.entities.ConfirmationToken;
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
	public Page<Service> findAllByRegistedAtAndStatus(org.springframework.data.domain.Pageable page, Date date,boolean status) {
		// TODO Auto-generated method stub
		return servicerepo.findAllByRegisteredAtAndStatus(page, date,status);
	}

	@Override
	public List<Service> findAllByStatus(boolean status) {
		// TODO Auto-generated method stub
		return servicerepo.findAllByStatus(status);
	}
	@Autowired
	private AccountService ac;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ConfirmationTokenService cm;
	@Autowired
	private DateHelperService date;
	@Autowired
	private MailService mail;
	@Override
	public int registationService(String mail, long id) {
		
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		if (ac.getAccountByMail(mail) != null) {
			try {
				Account acount = ac.getAccountByMail(mail);
				acount.setRole(roleService.getById(2));
				Service s = getById(id);
				s.setStatus(true);
				s.setAccount(acount);
				s.setCreatedAt(date.convetDatetoSql(dtf.format(now)));
				s.setViewer(0);
				update(s);
				return 1;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return -1;
			}

		} else {

			try {
				Account acount = new Account();
				acount.setRole(roleService.getById(2));
				acount.setMail(mail);
				acount.setPassword(ac.genPassWord(8));
				acount.setStatus(false);
				acount.setCreated_at(date.convetDatetoSql(dtf.format(now)));
				ac.save(acount);
				ConfirmationToken tk = new ConfirmationToken(acount);
				cm.save(tk);
				this.mail.mailContent(acount,
								"Your Registation is complete : \n"  
								+ " This is your mail: " + acount.getMail() +" : \n"
								+ " This is your password: " + acount.getPassword()+" : \n"
								+ " Please Click That Link To Active Your Account" +" : \n"
								+ " http://localhost:8090/confirm-account/"+ tk.getConfirmation_token());

				Service s = getById(id);
				s.setStatus(true);
				s.setCreatedAt(date.convetDatetoSql(dtf.format(now)));
				s.setAccount(ac.getAccount(mail));
				s.setViewer(0);
				update(s);
				return 1;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return -1;
			}

		
	}
		
	}
	@Override
	public int declineService(long id,String mail) {
		// TODO Auto-generated method stub
		Service s = getById(id);
		try {
			delete(s);
			Account ac = new Account();
			ac.setMail(mail);
			this.mail.mailContent(ac, "Registation falied ! \n"
					+ "Please Check Your Service Information And Re-register ! \n"
					+ "Contact with Us: \n"
					+ "http://localhost:8090/contact");
			return 1;
		} catch (Exception e) {
			return -1;	// TODO: handle exception
		}
		
	}
}


