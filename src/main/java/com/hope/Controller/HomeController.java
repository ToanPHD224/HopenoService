package com.hope.Controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hope.DTO.BookDTO;
import com.hope.Service.AccountService;
import com.hope.Service.ConfirmationTokenService;
import com.hope.Service.DateHelperService;
import com.hope.Service.MailService;
import com.hope.Service.RoleService;
import com.hope.Service.ServiceService;
import com.hope.Service.ServiceSettingsService;
import com.hope.entities.Account;
import com.hope.entities.ConfirmationToken;
import com.hope.entities.Service;

@Controller
public class HomeController {
	
	@GetMapping("/about")
	public String viewAbout()
	{
		return "/customer/about";
	}
	
	@GetMapping("/contact")
	public String viewContact()
	{
		return "/customer/contact";
	}
	@GetMapping("/admin/home")
	public String getHome()
	{
		return "/admin/index";
	}
	@GetMapping("/login")
	public String getLogin()
	{
		return "/login";
	}
	
	
	@Autowired
	private ServiceService serviceService;
	@Autowired DateHelperService dateHelp;
	@GetMapping("/getservice")
	@ResponseBody
	public String getService( @RequestParam("quan") String quan, @RequestParam("start")float start , @RequestParam("end") float end , @RequestParam("date") String date ,ModelMap md) throws ParseException
	{
		md.addAttribute("date",date);
		md.addAttribute("quan",quan);
		md.addAttribute("start",start);
		md.addAttribute("duration", end-start);
		List<Service> list =  serviceService.getAllServiceForArtibiue(quan, date, start, end);
		if(list.size()>0)
		{
			md.addAttribute("listService",list);
			return "viewservice" + list.get(0).getName();
		}
		else
		{
			md.addAttribute("name", "Khong co san nao");
			return "viewservice" + " Khong co san nao";
		}
		
	}
}
