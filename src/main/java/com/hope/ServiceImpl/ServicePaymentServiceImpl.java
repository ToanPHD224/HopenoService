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
	private DateHelperService date;
	@Autowired
	private ServicePaymentService servicepayment;

	@Override
	public boolean sendAllPayment() {
		LocalDate currentdate = LocalDate.now();
		int month = currentdate.getMonthValue();
		List<ServicePayment> list = isVailPayment(month);
		if (list.size() > 0) {
			return false;
		}

		try {
			List<com.hope.entities.Service> listService = service.findAll();

			for (int i = 0; i < listService.size(); i++) {
				int totalBook = 0;
				float totalPay = 0;
				float totalFee = 0;

				float feeBook = listService.get(i).getServicefee().getBooking_Fee();
				List<Payment> p = paymentservice.getAllPayMent(date.convetDatetoSql(getDate()[0]),
						date.convetDatetoSql(getDate()[1]), listService.get(i).getId());
				System.out.println(p.toString());
				totalBook = p.size();
				for (int j = 0; j < p.size(); j++) {
					System.out.println(p.get(j).getAmount());
					totalPay += p.get(j).getAmount();
					float duration = p.get(j).get_end() - p.get(j).get_start();
					float feeBookOneTime = (feeBook / 100) * p.get(j).getAmount();
					totalFee += feeBookOneTime * duration;
				}
				ServicePayment s = new ServicePayment(totalBook, listService.get(i),
						listService.get(i).getServicefee().getName(), totalPay, totalFee, month, false);
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
	public List<ServicePayment> isVailPayment(int month) {
		List<ServicePayment> list = sPR.isVailPayment(month);
		return list;
	}

}
