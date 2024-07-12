package com.ntr153.telusko.springbootrest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Client <-> Servlet Container <-> Security Filter1 <-> Sercurity Filter2 <-> .... <-> servlet
    // the abover security filter chain, we are configuring it here
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        
        httpSecurity.csrf(customizer -> customizer.disable());      
                // disable csrf
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());    
                // enabling security for the requests
                // even with above line, the site won't work
        // httpSecurity.formLogin(Customizer.withDefaults());
                // to enable site login
        httpSecurity.httpBasic(Customizer.withDefaults());      
                // to enable postman API's
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                // making the project stateless i.e. different session id everytime
                // formLogin must be disabled for stateless as we won't be able to use the ui; only postman can be used
                // because everytime we search for any address, we will get login page only as session id changes
                // disabling the formLogic will not disable authentication itself. 
                // It'll will provide us a popup for username and password on the ui.

        return httpSecurity.build();
    }

    // Removing dependency on application.properties for authorizing logins and uses UserDetails for credential verification
//     @Bean
//     public UserDetailsService inMemoryUserDetailsService() {

//         UserDetails userdetails = User
//                                     .withDefaultPasswordEncoder()
//                                     .username("ntr153")
//                                     .password("0000")
//                                     .roles("USER")      // can also be "ADMIN" with or without csv
//                                     .build();

//         UserDetails adminDetails = User
//                                     .withDefaultPasswordEncoder()
//                                     .username("admin")
//                                     .password("0000")
//                                     .roles("ADMIN")
//                                     .build();    

//         return new InMemoryUserDetailsManager(userdetails, adminDetails);     // multiple user details can be passed as csv
//     }

    @Autowired
    private UserDetailsService daoUserDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(daoUserDetailsService);
        // provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());     // No Encoder
        provider.setPasswordEncoder(new BCryptPasswordEncoder(BCryptVersion.$2A, 12));

        return provider;
    }
}