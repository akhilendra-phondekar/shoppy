package com.gen.ai.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gen.ai.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSender mailSender;
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

	}

}
