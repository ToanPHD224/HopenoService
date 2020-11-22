package com.hope.AdminController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hope.Service.DateHelperService;
import com.hope.Service.ServicePaymentService;
import com.hope.Service.ServiceService;
import com.hope.entities.Service;

@Controller
@RequestMapping("/admin/")
@CrossOrigin
public class AdminController {
	private final String admin ="/admin/";
	@Autowired
	private ServiceService service;
	@Autowired
	private DateHelperService datesv;
	@GetMapping("registerform")
	public String showBill(ModelMap md, @RequestParam(value = "date", required=false) String date , @RequestParam(value = "pageNumber",required = false) int page)
	{

		String currentdate = "";
		
		if(date==null)
		{
			currentdate = LocalDate.now().toString();
			md.addAttribute("date", currentdate);
		}
		else
		{
			currentdate = date;
			md.addAttribute("date", currentdate);
			
		}
		Pageable pageable = PageRequest.of(page, 4);
		Page<Service> getPage =  service.findAllByRegistedAt(pageable, datesv.convetDatetoSql(date));
		List<Service> list = new ArrayList<Service>();
		for (Service service : getPage) {
			list.add(service);			
		} 

		List<Service> service1 = service.getAllRegistationServive(datesv.convetDatetoSql(currentdate));	
		
		md.addAttribute("listService",list);
		return admin+"registerserviceform";
	}
	
	@GetMapping("servicesettings")
	public String  serviceSettings()
	{
		return admin+"servicesettings";
	}
	@GetMapping("/addservicetype")
	public String addServiceType()
	{
		return admin+"addservicetype";
	}
	@GetMapping("/showalluser")
	private String showAllUser()
	{
		return admin+"showalluser";
	}
	@GetMapping("/showpayment")
	public String showPayment()
	{
		return admin+"showpaymentbill";
	}
	@GetMapping("/showservice")
	public String showService()
	{
		return admin+"showservice";
	}
	@GetMapping("/showfeedback")
	public String showFeedBack()
	{
		return admin+"showfeedback";
	}
	@Autowired
	private ServicePaymentService s;
	@GetMapping("/sendBill")
	@ResponseBody
	public String sendBill()
	{
		if(s.sendAllPayment() == true)
		{
			return "thanh cong";
		}
		return "that bai";
	}
}

