package com.ormb.app.ormbapp.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
// @Qualifier("SMSService")
public class SmsService  implements MessageService{
    
    @Override
    public String getMessage() {
        return "Sending SMS message";
    }
}
