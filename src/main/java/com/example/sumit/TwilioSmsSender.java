package com.example.sumit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);
	
	private final TwilioConfiguration twilioConfiguration;
	
	@Autowired
	public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
		
		this.twilioConfiguration = twilioConfiguration;
	}

    @Override
	public void sendSms(SmsRequest smsRequest) 
	   {
		if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
			PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
			String message = smsRequest.getMessage();
			MessageCreator creator = Message.creator(to, from, message);
			creator.create();
			LOGGER.info("send sms {} "+smsRequest);;
		}
		else
		{
			throw new IllegalArgumentException( "phone number:"+smsRequest.getPhoneNumber()+"is not valid");
			
		}
				
	}
	
    private boolean isPhoneNumberValid(String phoneNumber) {
		return true;
	}

}
