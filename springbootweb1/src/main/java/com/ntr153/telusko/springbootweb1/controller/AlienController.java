package com.ntr153.telusko.springbootweb1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ntr153.telusko.springbootweb1.entity.Alien;

@Controller
public class AlienController {

    @ModelAttribute("course")       // set variable course as desired.
    public String courseName() {
        return "Java";
    }

    // http://localhost:8080/alien
    @GetMapping("/alien")
    public String alienPage() {
        System.out.println("On Alien Page");
        return "alienCreation";
    }

    // http://localhost:8080/createAlien?aId=05&aName=Nirmal+R
    @GetMapping("createAlien")
	public String createAlien(@ModelAttribute("alien1") Alien alien) {
                    // @ModelAttribute needed when object name and index file attribute name are diff.
        System.out.println("Add Alien called");
		return "alienCreated";
	}
}
