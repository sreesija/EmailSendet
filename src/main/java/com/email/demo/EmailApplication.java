package com.email.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.email.model.Mail;
import com.email.service.EmailService;

@SpringBootApplication
@ComponentScan("com.email.service")
public class EmailApplication implements ApplicationRunner {

	@Autowired
	private EmailService emailService;

	private static Logger log = LoggerFactory.getLogger(EmailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	public void run(ApplicationArguments args) throws Exception {
//		log.info("START... Sending email");
		Mail mail = new Mail();
		mail.setFrom("customersupport@theosm.co.in");
		mail.setMailTo("sreekumars@theosm.co.in");
		mail.setSubject("Welcome to The OSM Academy");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", "Sreekumar!");
		model.put("location", "India");
		model.put("sign", "OSMSupport");
		mail.setProps(model);
		emailService.sendEmail(mail);
		log.info("END... Email sent success");

	}
}
