package com.hope.AdminController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hope.Service.DateHelperService;
import com.hope.Service.ServicePaymentService;
import com.hope.Service.ServiceService;
import com.hope.entities.Service;

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
			@RequestParam(value = "pageNumber", required = false) String page ,
			@RequestParam(value = "message" ,required = false) String message
			) {

		String currentdate = "";
		int pageNumber = 1;
		if (date == null) {
			currentdate = LocalDate.now().toString();
			md.addAttribute("date", currentdate);
		} else {
			currentdate = date;
			System.err.println(currentdate);
			md.addAttribute("currentdate", currentdate);
			md.addAttribute("message", message);

		}
		if (page != null) {
			pageNumber = Integer.parseInt(page);
		}
		Pageable pageable = PageRequest.of(pageNumber - 1, 2);
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
		// List<Service> service1 =
		// service.getAllRegistationServive(datesv.convetDatetoSql(currentdate));
		md.addAttribute("listService", list);
		return admin + "registerserviceform";
	}
	@PostMapping("registerform")
	public String acceptService(@RequestParam("action") String action, @RequestParam("id") long id,
			@RequestParam("mail") String mail, @RequestParam("currentdate") String currentdate, ModelMap md) {
		    md.addAttribute("message", "falied!");
			if (action.equals("accept")) {
			int status = service.registationService(mail, id);
			if(status==1)
			{
				md.addAttribute("message", "Registation Susscess");
			}
			
				
			return "redirect:/admin/registerform?date="+currentdate;
		} else {
			return "redirect:/admin/registerform?date="+currentdate;
		}

	}

	@GetMapping("servicesettings")
	public String serviceSettings() {
		return admin + "servicesettings";
	}

	@GetMapping("/addservicetype")
	public String addServiceType() {
		return admin + "addservicetype";
	}

	@GetMapping("/showalluser")
	private String showAllUser() {
		return admin + "showalluser";
	}

	@GetMapping("/showpayment")
	public String showPayment() {
		return admin + "showpaymentbill";
	}

	@GetMapping("/showservice")
	public String showService() {
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
