package com.ormb.app.ormbapp.service;

import org.springframework.stereotype.Service;

@Service
// @Qualifier("SMSService")
public class SmsService  implements MessageService{
    
    @Override
    public String getMessage() {
        return "Sending SMS message";
    }
}
