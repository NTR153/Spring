package com.ntr153.telusko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.ntr153.telusko.Alien;
import com.ntr153.telusko.Desktop;
import com.ntr153.telusko.Computer;


// for java based config ()

@Configuration
public class AppConfig {
    
    @Bean
    // public Alien alien(@Qualifier("desktop123") @Autowired Computer comp) {     // Qualifier is same as name in xml, will pick desktop123 as default bean
    public Alien alien(Computer comp) {
        System.out.println("Alien being created using alien()");
        Alien obj1 = new Alien();
        obj1.setAge(25);
        // obj1.setComp(desktop());        // calling the desktop from AppConfig itself and assigning it to Computer object
        obj1.setComp(comp);
        return obj1;
    }

    @Bean
    @Primary                            // This bean will be used in case of any confusion
    public Desktop desktopXYZ() {       // The name of the bean is the name of method itself
        System.out.println("Desktop being created using desktopXYZ()");
        return new Desktop();
    }

    @Bean(name={"desktop123","desktopLMN"})     // Any of these names can be used
    @Scope("prototype")
    public Desktop desktop() {
        System.out.println("Desktop being created using desktop()");
        return new Desktop();
    }
}
