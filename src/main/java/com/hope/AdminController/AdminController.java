package com.hope.AdminController;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.hope.Service.AccountService;
import com.hope.Service.DateHelperService;
import com.hope.Service.FeedBackService;
import com.hope.Service.MailService;
import com.hope.Service.PaymentService;
import com.hope.Service.ServiceFeeService;
import com.hope.Service.ServicePaymentService;
import com.hope.Service.ServiceService;
import com.hope.Service.UpLoadFileService;
import com.hope.entities.Account;
import com.hope.entities.FeedBack;
import com.hope.entities.Payment;
import com.hope.entities.Service;
import com.hope.entities.ServiceFee;
import com.hope.entities.ServicePayment;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	/* Dependency --------------------------------------------------------------------------------------------- */
	private final String admin = "/admin/";
	@Autowired
	private ServiceService service;
	@Autowired
	private DateHelperService datesv;
	@Autowired
	private FeedBackService fbR;
	@Autowired
	private ServiceFeeService sVF;
	@Autowired
	private UpLoadFileService upS;
	@Autowired
	private AccountService ac;
	@Autowired
	private MailService mailse;
	@Autowired
	private ServicePaymentService s;
	@Autowired
	private PaymentService paymentService;
	/* End -----------------------------------------------------------------------------------------------------*/
	/* Service -------------------------------------------------------------------------------------------------*/

	@GetMapping("/service/register")
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
		Pageable pageable = PageRequest.of(pageNumber - 1, 1);
		Page<Service> getPage = service.findAllByRegistedAtAndStatus(pageable, datesv.convetDatetoSql(currentdate), 0);
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
		return admin + "service";
	}

	@PostMapping("/service/register")
	public String registationService(@RequestParam("action") String action, @RequestParam("id") long id,
			@RequestParam("mail") String mail, @RequestParam("currentdate") String currentdate, ModelMap md) {
		md.addAttribute("message", "falied!");
		if (action.equals("accept")) {
			int status = service.registationService(mail, id);
			if (status == 1) {
				md.addAttribute("message", "Registation Susscess");
			}

			return "redirect:/admin/service/register?date=" + currentdate;
		} else {
			md.addAttribute("message", "Falied!");
			int status = service.declineService(id, mail);
			if (status == 1) {
				md.addAttribute("message", "Decline Susscess");
			}
			return "redirect:/admin/service/register?date=" + currentdate;
		}

	}

	@SuppressWarnings("unused")
	@GetMapping("/service/viewdetail/{id}")
	public String viewDetailService(@PathVariable("id") long id, ModelMap md) {
		Service s = service.getById(id);
		System.out.println(s.getStatus());
		if (s.getStatus() != 0) {
			String book = service.getTotalBook(id);
			String totalAmout = service.getTotalAmount(id);
			float total = 0;
			if (totalAmout != null) {
				float amount = Float.parseFloat(totalAmout);
				int booking = Integer.parseInt(book);
				total = amount * ((float) (booking) / 100);
				System.out.println(total);
			}
			List<FeedBack> getFeedBack = fbR.getTopFiveFeedBackByService(id);
			md.addAttribute("listfeedback", getFeedBack);
			md.addAttribute("service", s);
			md.addAttribute("totalbook", book);
			md.addAttribute("totalAmout", total);
			md.addAttribute("totalService", service.getToltalService(s.getAccount().getId()));
			md.addAttribute("avgFee", service.getAVGFee(id));
			md.addAttribute("avgRate", fbR.getAVGRating(id));
			return admin + "viewdetailservice";
		} else {
			return "redirect:/admin/service/getall";
		}
	}

	@GetMapping("/service/getall")
	public String showService(ModelMap md, @RequestParam(value = "id", defaultValue = "", required = false) String id) {
		System.out.println(id);

		List<Service> service;
		if (id.length() <= 0) {
			service = this.service.findAllServiceAceptandActive();

		} else {

			service = this.service.findAllServiceAceptandActive(Long.parseLong(id));

		}

		md.addAttribute("listService", service);

		return admin + "showservice";
	}

	@PostMapping("/service/action")
	public String updateService(@RequestParam("id") long id) {
		Service sv = service.getById(id);
		System.out.println(sv.isBanned());
		if (sv.isBanned() == true) {
			sv.setBanned(false);
		} else {
			sv.setBanned(true);
		}
		service.update(sv);
		return "redirect:/admin/service/viewdetail/" + id;
	}

	@GetMapping("/service/payment/sendpayment")
	public String sendBill(ModelMap md) {
	
			if (s.sendAllPayment() == true) {
				md.addAttribute("message", "Success !");
				return "redirect:/admin/service/payment/getbill";
			} else {
				md.addAttribute("message", "Sended !");
				return "redirect:/admin/service/payment/getbill";
			}
		

	}

	@GetMapping("/service/payment/getbill")
	public String getBill(ModelMap md, @RequestParam(value = "month", required = false) String month,
			@RequestParam(value = "message", required = false) String message) {
		System.out.println(month);
		List<ServicePayment> servicePayment;	
		LocalDate date = LocalDate.now();
		md.addAttribute("message", message);
		if (month==null) {
			System.out.println("aaaaaaaaaa");
			servicePayment = s.listServicePayment(date.getMonthValue());
		} else {
			servicePayment = s.listServicePayment(Integer.parseInt(month));
		}

		md.addAttribute("listPayment", servicePayment);

		return admin + "showpaymentbill";
	}

	/* End Service */

	/* Service Type */
	@GetMapping("/servicetype/getall/{pageNumber}")
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

	@GetMapping("/servicetype/add")
	public String addServiceType(ModelMap md) {

		ServiceFee serviceFee = new ServiceFee();
		serviceFee.setStatus(true);

		md.addAttribute("serviceFee", serviceFee);
		return admin + "addservicetype";
	}

	@PostMapping("/servicetype/add")
	public String addSercicetype(@RequestParam("action") String action, @RequestParam("bookfee") float bookFee,
			@RequestParam("name") String name, @RequestParam("file") MultipartFile file, ModelMap md,
			HttpServletRequest request) {
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
			int check = upS.upFile("admin", file, request);
			if (check == -1) {
				md.addAttribute("mesage", "Falied");
				return "redirect:/admin/addservicetype/";
			} else if (check == 0) {
				md.addAttribute("message", "Image is not pass 50 MB");
				return "redirect:/admin/addservicetype/";
			}

			sVF.save(sv);
			md.addAttribute("message", "Sussces");
			return "redirect:/admin/servicetype/getall/1";
		} else {
			return "redirect:/admin/servicetype/getall/1";
		}

	}

	@GetMapping("/servicetype/action")
	public String updateService(ModelMap md, @RequestParam("id") long id, @RequestParam("action") String action) {
		System.out.println("abc");
		if (action.equals("update")) {
			md.addAttribute("serviceFee", sVF.getById(id));
			return admin + "updatetypeservice";
		} else {
			ServiceFee sr = sVF.getById(id);
			if (sr.isStatus() == true) {
				sr.setStatus(false);
			} else {
				sr.setStatus(true);

			}
			sVF.update(sr);
			return "redirect:/admin/servicetype/getall/1";
		}

	}

	@SuppressWarnings("unused")
	@PostMapping("/servicetype/update")
	public String updateService(ModelMap md, @ModelAttribute("serviceFee") ServiceFee sr,
			@RequestParam("action") String action, @RequestParam("file") MultipartFile file,

			HttpServletRequest request) {
		System.out.println(file.getOriginalFilename());
		if (action.equals("save")) {
			try {
				if (file.isEmpty() == false) {
					System.out.println("aaaaaaa");
					sr.setImage(file.getOriginalFilename());
					sr.setStatus(true);
					int check = upS.upFile("admin", file, request);
					if (check == 0) {
						md.addAttribute("message", "Image is not pass 50 MB");
						return admin + "updatetypeservice?id=" + sr.getId();
					}
				} else {
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
			return "redirect:/admin/servicetype/getall/1";
		} else {
			return "redirect:/admin/servicetype/getall/1";
		}
	}
	/* End ServiceType --------------------------------------------------------------------------------------------- */

	/* Users --------------------------------------------------------------------------------------------------------*/
	@GetMapping("/users/getall")
	private String user(ModelMap md,
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) int pageNumber,
			@RequestParam(defaultValue = "", value = "mail", required = false) String mail) {
		Pageable page = PageRequest.of(pageNumber - 1, 6);
		Page<Account> getPage = ac.findAll(page);
		if (mail.length() > 0) {
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
		md.addAttribute("listUser", list);
		return admin + "user";
	}

	@GetMapping("/users/action/{id}")
	public String actionAccount(@PathVariable(value = "id") long id) {
		Account acount = ac.getById(id);
		if (acount.isBanned() == true) {
			acount.setBanned(false);
		} else {
			acount.setBanned(true);
		}
		ac.update(acount);
		return "redirect:/admin/users/getall";
	}
	@GetMapping("/users/viewdetails/{id}")
	public String viewDetailsAccount()
	{
		return admin+"userdetails";
	}

	/* End Users--------------------------------------------------------------------------------------------------------- */

	/* FeedBack---------------------------------------------------------------------------------------------------------- */
	@GetMapping("/feedback/getall")
	public String showFeedBack(@RequestParam(value = "pageNumber", defaultValue = "1", required = false) int pageNumber,
			@RequestParam(value = "date", required = false) String date, ModelMap md) {
		String currentdate = "";
		if (date == null) {
			currentdate = LocalDate.now().toString();
			md.addAttribute("currentdate", currentdate);
		} else {
			currentdate = date;
			md.addAttribute("currentdate", currentdate);
		}
		Pageable page = PageRequest.of(pageNumber - 1, 6);
		Page<FeedBack> getPage = fbR.findAllByTypeAndCreatedAt(3, datesv.convetDatetoSql(currentdate), page);
		int currentPageNumber = getPage.getNumber() + 1;
		int beginIndex = Math.max(1, currentPageNumber - 6);
		int endIndex = Math.min(beginIndex + 10, getPage.getTotalPages());
		md.addAttribute("totalPages", getPage.getTotalPages());
		md.addAttribute("currentPageNumber", currentPageNumber);
		md.addAttribute("beginIndex", beginIndex);
		md.addAttribute("endIndex", endIndex);
		List<FeedBack> list = new ArrayList<FeedBack>();
		for (FeedBack feedBack : getPage) {
			list.add(feedBack);
		}
		md.addAttribute("size", list.size());
		md.addAttribute("listFeedBack", list);
		System.out.println("abc");
		return admin + "showfeedback";
	}

	@GetMapping("/feedback/detail")
	public String detailFeedback(@RequestParam("id") String id, ModelMap md) {
		if (id.length() <= 0) {
			return "redirect:/admin/feedback/getall";
		}

		FeedBack fb = fbR.getById(Long.parseLong(id));
		md.addAttribute("feedback", fb);
		return admin + "detailfeedback";
	}

	/* End FeedBack--------------------------------------------------------------------------------------------------------------*/


	/* Contact--------------------------------------------------------------------------------------------- ----------------------*/
	@GetMapping("/contact")
	public String sendMailToUser(@RequestParam(value = "mail", required = false) String mail, ModelMap md) {

		md.addAttribute("mail", mail);
		return admin + "mailcontact";
	}
	@PostMapping("/contact")
	public String sendMail(@RequestParam(value = "editordata") String content,
			@RequestParam(value = "mail") String mail, @RequestParam(value = "action") String action,
			@RequestParam(value = "subject") String subject, ModelMap md) {
		if (action.equals("send")) {
			try {
				System.out.println("aaaaaaas");
				Account acount = this.ac.getAccountByMail(mail);
				System.out.println(acount.getMail() + "Alo");
				mailse.mailContent(acount, content, subject);
				System.out.println("anc");
				md.addAttribute("message", "Success!");
			} catch (Exception e) {
				// TODO: handle exception
				md.addAttribute("message", "Falied!");
			}
			System.out.println("abc");
			return admin + "mailcontact";
		} else {
			return "redirect:/admin/";
		}
	}
	/* End Contact--------------------------------------------------------------------------------------------- ---------------*/
	@Autowired
	PasswordEncoder p ;
	@GetMapping("")
	public String getHome(ModelMap md)
	{
		LocalDate date = LocalDate.now();
		String book= this.s.countBook(date.getMonthValue());
		String totalFee = this.s.countFee(date.getMonthValue());
		String totalAccount = ac.countAcount();
		String totalRegister = this.service.countRegisterForm(datesv.convetDatetoSql(LocalDate.now().toString()));
		md.addAttribute("book", book);
		md.addAttribute("totalFee", totalFee);
		md.addAttribute("totalAccount",totalAccount);
		md.addAttribute("totalRegister", totalRegister);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			String bookmonth = this.s.countBook(i);
		
			if(bookmonth==null)
			{
				list.add(0);
			}
			else
			{
				list.add(Integer.parseInt(bookmonth));
			}	
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		md.addAttribute("bookMonth", list);
		return admin+"index";
	}
}
