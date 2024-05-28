package com.ormb.app.ormbapp.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
// @Primary
//  @Qualifier("EmailService")
public class EmailService implements MessageService {
    
    @Override
    public String getMessage() {
        return "Sending email message";
    }
}
