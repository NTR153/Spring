package com.ntr153.telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ntr153.telusko.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args)
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Note : All the singleton beans are created on application loading itself
        System.out.println();

        Desktop dt = context.getBean("desktopXYZ", Desktop.class);        // The name of the bean is the name of method itself
        dt.compile();

        System.out.println();

        Desktop dt2 = context.getBean("desktop123", Desktop.class);        // The name of the bean is the name of method itself
        dt2.compile();

        System.out.println();

        ((AnnotationConfigApplicationContext) context).close();




        /* Working XML config based code below - */
        /* 
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        System.out.println();

        Alien alien1_0 = (Alien) context.getBean("alien1");
        alien1_0.setAge(21);
        // alien1_0.code();
        System.out.println("alien1_0 age - " + alien1_0.getAge());
        System.out.println("Inner bean implemented, company - " + alien1_0.getComp());

        System.out.println();

        Alien alien1_1 = (Alien) context.getBean("alien1");
                                                // Even if we have different references, the object remains the same if the id name is same.
        // alien1_1.code();
        System.out.println("alien1_1 age - " + alien1_1.getAge());

        System.out.println();

        Alien alien2 = (Alien) context.getBean("alien2");
        System.out.println("alien2 age - " + alien2.getAge());      // The value of age comes from injection in xml document
        alien2.code();
        System.out.println(alien2.getComp());

        System.out.println();

        Computer laptop1 = context.getBean("lap1", Computer.class);     // No need for type casting using this syntax
        // laptop1.setCompany("Lenovo");
        System.out.println(laptop1);

        System.out.println();

        Laptop laptop2 = context.getBean("lap1", Laptop.class);
        laptop2.setCompany("DELL");                         // Re-setting
        laptop2.setModel("G15");                              // Re-setting
        System.out.println(laptop2);

        System.out.println();

        Desktop desk1 = context.getBean(Desktop.class);    // No need for id for bean creation if calling by type
                                                            // Need only one bean with type desktop defined or need a primary="true" bean
                                                // primary="true" is also required when getting a parent class but xml file has multiple child beans
        System.out.println(desk1);

        ((ClassPathXmlApplicationContext) context).close();

        */
    }
}
