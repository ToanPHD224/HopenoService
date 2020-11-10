package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hope.entities.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
