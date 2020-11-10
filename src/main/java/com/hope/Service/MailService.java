package com.hope.Service;

import org.springframework.mail.SimpleMailMessage;

import com.hope.entities.Account;
import com.hope.entities.ConfirmationToken;

public interface MailService {
	public void mailContent(Account ac,ConfirmationToken c);
	public boolean sendConfirm(SimpleMailMessage mail);
}
