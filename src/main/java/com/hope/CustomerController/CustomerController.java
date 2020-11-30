package com.hope.CustomerController;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hope.Repository.FeedBackRepo;
import com.hope.Service.FeedBackService;
import com.hope.Service.ServiceFeeService;
import com.hope.Service.ServiceService;
import com.hope.Service.SportFieldService;
import com.hope.entities.Service;
import com.hope.entities.ServiceDetails;
import com.hope.entities.ServiceFee;
@Controller
@RequestMapping("/customer/")
public class CustomerController {
	private final String folder = "/customer/";	
	@Autowired
	private ServiceFeeService svc;
	@Autowired
	private ServiceService sv;
	@Autowired
	private FeedBackService fbR;
	@Autowired
	private SportFieldService spf;
	@GetMapping("")
	public String getHomeCustomer(ModelMap md)
	{
		List<ServiceFee> list = svc.getAllServiceByStatus();
		md.addAttribute("listType", list);
		return folder + "selecttype";
	}
	
	@GetMapping("selecttype/{id}")
	public String getType(@PathVariable("id") long id,ModelMap md)
	{
		
		List<Service> listService = sv.getRandomService(id);
		List<ServiceDetails> listDetails = new ArrayList<ServiceDetails>();
	
		for (int i = 0; i < listService.size(); i++) {		
		
			float avgRating = fbR.getAVGRating(id);
			int countFiled = spf.countToltalSportFiledById(id);
			float avgFee = sv.getAVGFee(id);
			
			ServiceDetails svt = new ServiceDetails(listService.get(i), avgRating,
					avgFee, 
					listService.get(i).getWard(), listService.get(i).getWard().getDistrics(), countFiled);
			listDetails.add(svt);
		}
		md.addAttribute("listService", listDetails);
		return folder+"index";
	}
	
	
}
