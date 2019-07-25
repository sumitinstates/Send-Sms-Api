package com.example.sumit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
    
	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
	
	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {

		Twilio.init(
				twilioConfiguration.getAccountSid(),
				twilioConfiguration.getAuthToken()
				);
		
		LOGGER.info("logger initalized", twilioConfiguration.getAccountSid());
	}
	
	
}
