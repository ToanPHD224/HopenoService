package com.hope.Service;

import com.hope.entities.Payment;

public interface PaymentService extends CrudEnties<Payment>{
	public float getAmountByServiceAndTime( float _start,float duration ,long service );

}
