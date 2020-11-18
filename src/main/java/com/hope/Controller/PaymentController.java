package com.hope.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hope.DTO.BookDTO;
import com.hope.Service.DateHelperService;
import com.hope.Service.PaymentService;
import com.hope.Service.ServiceService;
import com.hope.entities.Payment;

@Controller
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ServiceService service;
	@Autowired
	private DateHelperService dateHelp;
	@GetMapping("/getamount")
	public String getamount(
			@RequestParam("date") String date ,
			@RequestParam("start") float start,
			@RequestParam("service") long id,
			@RequestParam("duration")  float duration,
			ModelMap md)
	{
		BookDTO b = new BookDTO(service.getById(id), dateHelp.convetDatetoSql(date), start, duration);
		md.addAttribute("booking", b);
		md.addAttribute("total", paymentService.getAmountByServiceAndTime(b.getStart(), b.getDuration(), b.getService().getId()));
		Payment p = new Payment();
		p.set_start(b.getStart());
		p.set_end(b.getStart()+duration);
		return "viewPayment"; 
	}

	
}
