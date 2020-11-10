package com.hope.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hope.Repository.PaymentRepo;
import com.hope.Service.PaymentService;
import com.hope.entities.Payment;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepo paymentrp;
	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentrp.findAll();
	}

	@Override
	public void update(Payment enties) {
		// TODO Auto-generated method stub
		paymentrp.save(enties);
	}

	@Override
	public void save(Payment entites) {
		// TODO Auto-generated method stub
		paymentrp.save(entites);
	}

	@Override
	public Payment getById(long id) {
		// TODO Auto-generated method stub
		return paymentrp.getOne(id);
	}

	@Override
	public void delete(Payment entites) {
		paymentrp.delete(entites);
		
	}

}
