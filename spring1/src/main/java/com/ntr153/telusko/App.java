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
        
        Alien alien1 = (Alien) context.getBean("alien1");
        alien1.age=21;
        // alien1.code();
        System.out.println(alien1.age);

        Alien alien2 = (Alien) context.getBean("alien1");       // Even if we have different references, the object remains the same if the id name is same.
        // alien2.code();
        System.out.println(alien2.age);

        Laptop laptop1 = (Laptop) context.getBean("lap");
        laptop1.company = "Lenovo";
        System.out.println(laptop1.company);

        Laptop laptop2 = (Laptop) context.getBean("lap");
        // laptop2.company = "hp";
        System.out.println(laptop2.company);
    }
}
