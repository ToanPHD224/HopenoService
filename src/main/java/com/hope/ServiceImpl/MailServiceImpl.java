package com.hope.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hope.Service.MailService;
import com.hope.entities.Account;
import com.hope.entities.ConfirmationToken;
@Service
public class MailServiceImpl implements MailService  {

	@Autowired
	private JavaMailSender mail;
	@Override
	public void mailContent(Account ac,ConfirmationToken c,String content)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(ac.getMail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("zockkidpro@gmail.com");
        mailMessage.setText(content);
        sendConfirm(mailMessage);
	}
	
	@Override
	public boolean sendConfirm(SimpleMailMessage mail) {
		// TODO Auto-generated method stub
		try {
			this.mail.send(mail);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	public void sendMailAcept(Account ac,ConfirmationToken c,String content)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(ac.getMail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("zockkidpro@gmail.com");
        mailMessage.setText(content);
        sendConfirm(mailMessage);
	}
	public void sendMailDecline(Account ac,ConfirmationToken c,String content)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(ac.getMail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("zockkidpro@gmail.com");
        mailMessage.setText(content);
        sendConfirm(mailMessage);
	}
	

}
