package com.example.sumit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

	private final SmsService service;
	
	@Autowired
	public Controller(SmsService service) {
		this.service = service;
	}

    @PostMapping
	public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		service.sendSms(smsRequest);
	}
	
	
}
