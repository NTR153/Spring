package com.ntr153.telusko;

import java.beans.ConstructorProperties;

// @Component
// @Scope("prototype")
public class Laptop implements Computer {

    private String company;
    private String model;

    @Override
    public String toString() {
        return "Laptop [company=" + company + ", model=" + model + "]";
    }

    public Laptop() {
        System.out.println("Laptop object created using default constructor");
    }

    @ConstructorProperties({"company","model"})
    public Laptop(String company, String model) {         // Parameterized constructor
        this.company = company;
        this.model = model;
        System.out.println("Laptop object created using parameterized constructor");
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
        System.out.println("Compiling using Laptop");
    }
}
