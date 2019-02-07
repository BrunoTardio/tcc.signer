package com.tcc.signer.services;

import org.apache.logging.log4j.message.SimpleMessage;


import com.tcc.signer.domain.Pedido;
import com.tcc.signer.domain.PessoaFisica;



public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMessage msg);
	
	void sendNewPasswordEmail(PessoaFisica pessoaFisica, String newPass);
}
