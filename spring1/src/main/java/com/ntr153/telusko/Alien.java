package com.ntr153.telusko;

public class Alien {

    private int age;
    private Computer comp;             // Laptop object is defined and injected in xml

    public Alien() {
        System.out.println("Alien object created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Alien setter called");
        this.age = age;
    }

    public void code() {
        System.out.println("Coding");
        comp.compile();
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }
}
