package com.ntr153.telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        Alien alien1_0 = (Alien) context.getBean("alien1");
        alien1_0.setAge(21);
        // alien1_0.code();
        System.out.println("alien1_0 age - " + alien1_0.getAge());

        System.out.println();

        Alien alien1_1 = (Alien) context.getBean("alien1");         // Even if we have different references, the object remains the same if the id name is same.
        // alien1_1.code();
        System.out.println("alien1_1 age - " + alien1_1.getAge());

        System.out.println();

        Alien alien2 = (Alien) context.getBean("alien2");
        System.out.println("alien2 age - " + alien2.getAge());                           // The value of age comes from injection in xml document
        alien2.code();
        System.out.println(alien2.getComp());

        System.out.println();

        Computer laptop1 = (Computer) context.getBean("lap1");
        // laptop1.setCompany("Lenovo");
        System.out.println(laptop1);

        System.out.println();

        Laptop laptop2 = (Laptop) context.getBean("lap1");
        laptop2.setCompany("DELL");                         // Re-setting
        laptop2.setModel("G15");                              // Re-setting
        System.out.println(laptop2);

        System.out.println();
    }
}
