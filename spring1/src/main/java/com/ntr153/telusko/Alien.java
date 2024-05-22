package com.ntr153.telusko;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    // @Value("21")
    private int age;
    // @Autowired                       // Not sure of the function
    @Qualifier("laptop")                // Same as class name but first letter is small, to multiple implementations issue
    private Computer comp;              // Laptop object is defined and injected in xml
                                        // make sure we have only one implementation available if using Component Stereotype or handle it
                                        // i.e. either of Desktop and Laptop

    public Alien() {
        System.out.println("Alien object created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Alien age setter called");
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
        System.out.println("Alien comp setter called");
        this.comp = comp;
    }
}
