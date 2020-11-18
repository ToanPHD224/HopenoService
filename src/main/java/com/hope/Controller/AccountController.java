package com.hope.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hope.Service.AccountService;
import com.hope.Service.ConfirmationTokenService;
import com.hope.entities.Account;

@Controller
public class AccountController {
	@GetMapping("/register")
	public String abc(ModelMap md)
	{
		Account ac = accountService.createAccount();
		System.out.println(ac.getRole());
		md.addAttribute("account",ac);
		return "register";
	}
	
	@Autowired
	private AccountService accountService;
	@PostMapping("/register")
	@ResponseBody
	public String regiser(ModelMap md, @ModelAttribute(name = "account") Account ac) {
		boolean rq = accountService.registerAccount(ac);
		if(rq == true) {
		md.addAttribute("message","Gui thanh cong");	
		return "Thanh Cong";
		}
		else
		{
			md.addAttribute("message","Gui that bai");	
		}	
		return "That bai";
	}
	@Autowired
	private ConfirmationTokenService confirm;
	@GetMapping("/confirm-account/{token}")
	@ResponseBody
	public String confirm(@PathVariable(name = "token") String token,ModelMap md) {
	
		boolean request = confirm.confirmToken(token);
		if(request==true)
		{
			md.addAttribute("message", "Thanh Cong");
			return "Thanh Cong";
		}
		md.addAttribute("message", "That Bai");
		return "That bai";
	}

}
