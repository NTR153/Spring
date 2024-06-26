package com.ntr153.telusko;

import java.beans.ConstructorProperties;

import org.springframework.stereotype.Component;

@Component("comp2")             // comp2 is a name, that can be used in a qualifier when not using java or xml based config
public class Desktop implements Computer {

    private String company;
    private String model;

    @Override
    public String toString() {
        return "Desktop [company=" + company + ", model=" + model + "]";
    }

    public Desktop() {
        System.out.println("Desktop object created using default constructor");
    }

    @ConstructorProperties({"company","model"})            // Required for autowire byName
    public Desktop(String company, String model) {         // Parameterized constructor
        this.company = company;
        this.model = model;
        System.out.println("Desktop object created using parameterized constructor");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void compile() {
        System.out.println("Compiling using Desktop");
    }
}
