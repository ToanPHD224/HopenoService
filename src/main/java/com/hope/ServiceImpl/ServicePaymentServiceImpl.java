package com.hope.ServiceImpl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.ServicePaymentRepo;
import com.hope.Service.DateHelperService;
import com.hope.Service.PaymentService;
import com.hope.Service.ServicePaymentService;
import com.hope.Service.ServiceService;
import com.hope.entities.Payment;
import com.hope.entities.ServicePayment;

@Service
public class ServicePaymentServiceImpl implements ServicePaymentService {
	@Autowired
	private ServicePaymentRepo sPR;

	@Override
	public List<ServicePayment> findAll() {
		// TODO Auto-generated method stub
		return sPR.findAll();
	}

	@Override
	public void update(ServicePayment enties) {
		// TODO Auto-generated method stub
		sPR.save(enties);
	}

	@Override
	public void save(ServicePayment entites) {
		// TODO Auto-generated method stub
		sPR.save(entites);
	}

	@Override
	public ServicePayment getById(long id) {
		// TODO Auto-generated method stub
		return sPR.getOne(id);
	}

	@Override
	public void delete(ServicePayment entites) {
		// TODO Auto-generated method stub
		sPR.delete(entites);

	}

	@Autowired
	private PaymentService paymentservice;
	@Autowired
	private ServiceService service;
	@Autowired
	private DateHelperService dateHelper;
	@Autowired
	private ServicePaymentService servicepayment;
	
	@Override
	public boolean sendAllPayment() {
		LocalDate currentdate = LocalDate.now();
		Date nearestDate = this.nearestPaymentDate();
		List<ServicePayment> list = isVailPayment(dateHelper.convetDatetoSql(currentdate.toString()));
		if (list.size() > 0) {
			return false;
		}

		try {
			List<com.hope.entities.Service> listService = service.findAllByStatus(2);

			for (int i = 0; i < listService.size(); i++) {
				int totalBook = 0;
				float totalPay = 0;
				float totalFee = 0;
				float feeBook = listService.get(i).getServicefee().getBooking_Fee();
				List<Payment> p ;
				if(nearestDate == null)
				{
					System.out.println(getDateByMonth(currentdate.getMonthValue())[0]);
					System.out.println(currentdate.toString());
					 p = paymentservice.getAllPayMent(dateHelper.convetDatetoSql(getDateByMonth(currentdate.getMonthValue())[0]),
						dateHelper.convetDatetoSql(currentdate.toString()), listService.get(i).getId());
				}
				else
				{
					System.out.println("aaaaaaaaaaa");
					p= paymentservice.getAllPayMent(nearestDate, dateHelper.convetDatetoSql(currentdate.toString()), listService.get(i).getId());
				}	
			
				
				totalBook = p.size();
				for (int j = 0; j < p.size(); j++) {
					totalPay += p.get(j).getAmount();
					float duration = p.get(j).get_end() - p.get(j).get_start();
					float feeBookOneTime = (feeBook / 100) * p.get(j).getAmount();
					totalFee += feeBookOneTime * duration;
				}
				ServicePayment s = new ServicePayment(totalBook, listService.get(i),
						listService.get(i).getServicefee().getName(), totalPay, totalFee, dateHelper.convetDatetoSql(currentdate.toString()), false);
				servicepayment.save(s);
	
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}

	}

	public String[] getDate() {
		LocalDate currentdate = LocalDate.now();
		Calendar c = Calendar.getInstance();
		final String start = "01";
		String endday = String.valueOf(c.getActualMaximum(Calendar.DAY_OF_MONTH));
		String month = String.valueOf(currentdate.getMonthValue());
		String year = String.valueOf(currentdate.getYear());
		String startDate = year + "-" + month + "-" + start;
		String endDate = year + "-" + month + "-" + endday;
		String[] datearr = { startDate, endDate };
		return datearr;
	}

	@Override
	public List<ServicePayment> isVailPayment(Date date) {
		List<ServicePayment> list = sPR.isVailPayment(date);
		return list;
	}

	@Override
	public String countBook(int month) {
	
		return sPR.countBook(dateHelper.convetDatetoSql(getDateByMonth(month)[0]),dateHelper.convetDatetoSql(getDateByMonth(month)[1]));
	}

	@Override
	public String countFee(int month) {
		// TODO Auto-generated method stub
		return sPR.countFee(dateHelper.convetDatetoSql(getDateByMonth(month)[0]),dateHelper.convetDatetoSql(getDateByMonth(month)[1]));
	}

	@Override
	public Date nearestPaymentDate() {
		// TODO Auto-generated method stub
		return sPR.nearestPaymentDate();
	}
	public String[] getDateByMonth(int month)
	{
		
		Calendar c = Calendar.getInstance();
		final String start = "01";
		String endday = dateHelper.getLastDateByMonth(month);
		String year = String.valueOf(c.get(Calendar.YEAR));
		String startDate = year +"-"+ String.valueOf(month) +"-" + start;
		String endDate = year + "-" + String.valueOf(month) +"-" + endday ;
		return new String[] {startDate,endDate};
	}

	@Override
	public List<ServicePayment> listServicePayment(int month) {
		// TODO Auto-generated method stub
		return sPR.listServicePayment(dateHelper.convetDatetoSql(getDateByMonth(month)[0]),dateHelper.convetDatetoSql(getDateByMonth(month)[1]));
	}

}
