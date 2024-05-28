package com.ormb.app.ormbapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ormb.app.ormbapp.entities.Person;
import com.ormb.app.ormbapp.repository.PersonRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
;

@Service
public class PersonServiceImpl {

    @Autowired
    private PersonRepositoryInterface personRepositoryInterface;

    Map<String, String> respMap = new HashMap<>();

    private Map<String, String> addPerson(Person person){
        personRepositoryInterface.save(person);
        respMap.put("message", "Employee Added Successfully");
		return respMap;

    }

    

}
