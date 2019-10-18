package com.lojamari.services;

import org.springframework.mail.SimpleMailMessage;

import com.lojamari.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
