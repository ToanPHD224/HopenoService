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
import com.hope.Service.MailService;
import com.hope.Service.RoleService;
import com.hope.entities.Account;
import com.hope.entities.ConfirmationToken;

@Controller
public class HomeController {

	@Autowired
	private AccountService accountdao;
	@Autowired
	private ConfirmationTokenService confirm;
	@Autowired
	private RoleService role;
	@Autowired
	private MailService mail;
	@GetMapping("/")
	@ResponseBody
	public String view()
	{
		return "<h1> ABC </h1>";
	}
	@GetMapping("/register")
	@ResponseBody
	public String abc(ModelMap md)
	{
		Account ac = new Account();
		ac.setMail("zockkidpro@gmail.com");
		ac.setPassword("123");
		md.addAttribute("account",ac);
		
		return "Thành Công";
	}
	@PostMapping("/register")
	@ResponseBody
	public String regiser(ModelMap md, @ModelAttribute(name = "account") Account ac) {
		Account newAc = accountdao.getAccountByMail(ac.getMail());
		if (newAc != null) {
			return "Tai Khoan Da Duoc Dang Ki";
		} else {
			ac.setRole(role.getById(1));
			accountdao.save(ac);
			ConfirmationToken c = new ConfirmationToken(ac);
			confirm.save(c);
			mail.mailContent(ac, c);
		}
		return "Thanh Cong";
	}

	@GetMapping("/confirm-account/{token}")
	@ResponseBody
	public String confirm(@PathVariable(name = "token") String token) {
		System.out.println(token);
		ConfirmationToken c = confirm.getConfirmationTokenByToken(token);
		if (c == null) {
			return "Không tìm thấy Token này";
		} else {
			Account ac = accountdao.getById(c.getAccount().getId());
			if (ac.isStatus() == true) {
				return "Tài Khoản Đã Xác Thực";
			}
			ac.setStatus(true);
			accountdao.update(ac);
			return "Thành Công";
		}
	}
}
