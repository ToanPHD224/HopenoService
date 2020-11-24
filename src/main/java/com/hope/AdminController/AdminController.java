package com.hope.AdminController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hope.Repository.ServiceFeeRepo;
import com.hope.Service.AccountService;
import com.hope.Service.DateHelperService;
import com.hope.Service.ServiceFeeService;
import com.hope.Service.ServicePaymentService;
import com.hope.Service.ServiceService;
import com.hope.Service.UpLoadFileService;
import com.hope.entities.Account;
import com.hope.entities.Service;
import com.hope.entities.ServiceFee;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	private final String admin = "/admin/";
	@Autowired
	private ServiceService service;
	@Autowired
	private DateHelperService datesv;

	@GetMapping("registerform")
	public String showBill(ModelMap md, @RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "pageNumber", required = false) String page,
			@RequestParam(value = "message", required = false) String message) {

		String currentdate = "";
		int pageNumber = 1;
		if (date == null) {
			currentdate = LocalDate.now().toString();
			md.addAttribute("date", currentdate);
		} else {
			currentdate = date;
			md.addAttribute("currentdate", currentdate);
			md.addAttribute("message", message);

		}
		if (page != null) {
			pageNumber = Integer.parseInt(page);
		}
		Pageable pageable = PageRequest.of(pageNumber - 1,1);
		Page<Service> getPage = service.findAllByRegistedAtAndStatus(pageable, datesv.convetDatetoSql(currentdate),
				false);
		int currentPageNumber = getPage.getNumber() + 1;
		int beginIndex = Math.max(1, currentPageNumber - 6);
		int endIndex = Math.min(beginIndex + 10, getPage.getTotalPages());
		md.addAttribute("totalPages", getPage.getTotalPages());
		md.addAttribute("currentPageNumber", currentPageNumber);
		md.addAttribute("beginIndex", beginIndex);
		md.addAttribute("endIndex", endIndex);

		List<Service> list = new ArrayList<Service>();
		for (Service service : getPage) {
			list.add(service);
		}
		md.addAttribute("size", list.size());
		// List<Service> service1 =
		// service.getAllRegistationServive(datesv.convetDatetoSql(currentdate));
		md.addAttribute("listService", list);
		return admin + "registerserviceform";
	}

	@PostMapping("registerform")
	public String registationService(@RequestParam("action") String action, @RequestParam("id") long id,
			@RequestParam("mail") String mail, @RequestParam("currentdate") String currentdate, ModelMap md) {
		md.addAttribute("message", "falied!");
		if (action.equals("accept")) {
			int status = service.registationService(mail, id);
			if (status == 1) {
				md.addAttribute("message", "Registation Susscess");
			}

			return "redirect:/admin/registerform?date=" + currentdate;
		} else {
			md.addAttribute("message", "Falied!");
			int status = service.declineService(id, mail);
			if (status == 1) {
				md.addAttribute("message", "Decline Susscess");
			}
			return "redirect:/admin/registerform?date=" + currentdate;
		}

	}

	@Autowired
	private ServiceFeeService sVF;

	@GetMapping("servicetype/{pageNumber}")
	public String serviceSettings(@PathVariable("pageNumber") int pageNumber, ModelMap md) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 3);
		Page<ServiceFee> listServiceFee = sVF.getAllService(pageable);
		int currentPageNumber = listServiceFee.getNumber() + 1;
		int beginIndex = Math.max(1, currentPageNumber - 6);
		int endIndex = Math.min(beginIndex + 10, listServiceFee.getTotalPages());
		md.addAttribute("totalPages", listServiceFee.getTotalPages());
		md.addAttribute("currentPageNumber", currentPageNumber);
		md.addAttribute("beginIndex", beginIndex);
		md.addAttribute("endIndex", endIndex);
		List<ServiceFee> list = new ArrayList<ServiceFee>();
		for (ServiceFee serviceFee : listServiceFee) {
			list.add(serviceFee);
		}
		md.addAttribute("size", list.size());
		System.out.println(list.size());
		md.addAttribute("listServiceFee", list);
		return admin + "servicetype";
	}

	@GetMapping("/addservicetype")
	public String addServiceType(ModelMap md) {

		ServiceFee serviceFee = new ServiceFee();
		serviceFee.setStatus(true);

		md.addAttribute("serviceFee", serviceFee);
		return admin + "addservicetype";
	}

	@Autowired
	private UpLoadFileService upS;

	@PostMapping("/addservicetype")
	public String addSercicetype(@RequestParam("action") String action, @RequestParam("bookfee") float bookFee,
			@RequestParam("name") String name, @RequestParam("file") MultipartFile file, ModelMap md) {
		if (action.equals("save")) {

			if (file.isEmpty()) {
				md.addAttribute("message", "Please select a file to upload");
				return "redirect:uploadStatus";
			}
			ServiceFee sv = new ServiceFee();
			sv.setStatus(true);
			sv.setImage(file.getOriginalFilename());
			sv.setBooking_Fee(bookFee);
			sv.setName(name);
			System.out.println(file.getOriginalFilename());
			int check = upS.upFile("admin", file);
			if (check == -1) {
				md.addAttribute("mesage", "Falied");
				return "redirect:/admin/addservicetype/";
			} else if (check == 0) {
				md.addAttribute("message", "Image is not pass 50 MB");
				return "redirect:/admin/addservicetype/";
			}

			sVF.save(sv);
			md.addAttribute("message", "Sussces");
			return "redirect:/admin/servicetype/1";
		} else {
			return "redirect:/admin/servicetype/1";
		}

	}

	@GetMapping("/updatetypeservice")
	public String updateService(ModelMap md, @RequestParam("id") long id, @RequestParam("action") String action) {
		System.out.println("abc");
		if (action.equals("update")) {
			md.addAttribute("serviceFee", sVF.getById(id));
			return admin + "updatetypeservice";
		} else {
			ServiceFee sr = sVF.getById(id);
			if(sr.isStatus()==true)
			{
				sr.setStatus(false);	
			}
			else
			{
				sr.setStatus(true);
			
			}	
			sVF.update(sr);
			return "redirect:/admin/servicetype/1";
		}

	}

	@SuppressWarnings("unused")
	@PostMapping("/updatetypeservice")
	public String updateService(ModelMap md, @ModelAttribute("serviceFee") ServiceFee sr,
			@RequestParam("action") String action, @RequestParam("file") MultipartFile file) {
		if (action.equals("save")) {
			try {
				if(file.isEmpty()==false)
				{
					System.out.println("aaaaaaa");
					sr.setImage(sr.getImage());
					sr.setStatus(true);
					int check = upS.upFile("admin", file);
					if (check == 0) {
						md.addAttribute("message", "Image is not pass 50 MB");
						return admin + "updatetypeservice";
					}
				}
				else
				{
					System.out.println("aloo");
					sr.setImage(sVF.getById(sr.getId()).getImage());
					sr.setStatus(true);
				}	
				sVF.update(sr);

			} catch (Exception e) {
				e.printStackTrace();
				md.addAttribute("message", "Falied !");
				// TODO: handle exception

			}
			md.addAttribute("message", "Update Success !");
			return "redirect:/admin/servicetype/1";
		} else {
			return "redirect:/admin/servicetype/1";
		}
	}
	@Autowired
	private AccountService ac;
	@GetMapping("/showalluser")
	private String showAllUser(ModelMap md,@RequestParam(value = "pageNumber",defaultValue = "1",required = false) int pageNumber ,
			@RequestParam(defaultValue = "",value = "mail",required = false) String  mail ) {
		Pageable page = PageRequest.of(pageNumber - 1, 6);
		Page<Account> getPage = ac.findAll(page);
		if(mail.length()>0)
		{
			getPage = ac.findAllByMail(page, mail);
		}
		int currentPageNumber = getPage.getNumber() + 1;
		int beginIndex = Math.max(1, currentPageNumber - 6);
		int endIndex = Math.min(beginIndex + 10, getPage.getTotalPages());
		md.addAttribute("totalPages", getPage.getTotalPages());
		md.addAttribute("currentPageNumber", currentPageNumber);
		md.addAttribute("beginIndex", beginIndex);
		md.addAttribute("endIndex", endIndex);

		List<Account> list = new ArrayList<Account>();
		for (Account account : getPage) {
			list.add(account);
		}
		md.addAttribute("size", list.size());
		md.addAttribute("listUser",list);
		return admin + "showalluser";
	}
	@GetMapping("/disableaccount/{id}")
	public String disableAccount(@PathVariable(value = "id") long id)
	{
		Account acount = ac.getById(id);
		if(acount.isBanned()==true)
		{
			acount.setBanned(false);
		}
		else
		{
			acount.setBanned(true);
		}	
		ac.update(acount);
		return "redirect:/admin/showalluser";
	}
	
	
	@GetMapping("/showpayment")
	public String showPayment() {
		return admin + "showpaymentbill";
	}

	@GetMapping("/showservice")
	public String showService(ModelMap md,@RequestParam(value = "mail",defaultValue = "",required = false) String mail) {
		List<Service> service = null ; 
		if(mail.length()>0)
		{
			service = this.service.findAllByMail(mail,true);
			
		}
		else
		{
			service = this.service.findAllByStatus(true);
		}	
		md.addAttribute("listService", service);
		return admin + "showservice";
	}

	@GetMapping("/showfeedback")
	public String showFeedBack() {
		return admin + "showfeedback";
	}

	@Autowired
	private ServicePaymentService s;

	@GetMapping("/sendBill")
	@ResponseBody
	public String sendBill() {
		if (s.sendAllPayment() == true) {
			return "thanh cong";
		}
		return "that bai";
	}
}
