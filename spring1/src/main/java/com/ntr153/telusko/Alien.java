package com.ntr153.telusko;

public class Alien {

    private int age;
    private Laptop lap;             // Laptop object is defined and injected in xml

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
        lap.compile();
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }
}
