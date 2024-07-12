package com.ntr153.telusko.spring_sec_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.spring_sec_demo.model.User;
import com.ntr153.telusko.spring_sec_demo.model.UserPrincipal;
import com.ntr153.telusko.spring_sec_demo.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        // Note: findById can also be used, but it would result in Optional<User> and we don't want to handle it now
        
        if (user==null) {
            System.out.println(String.format("User {} 404",username));
            throw new UsernameNotFoundException(String.format("User {} 404",username));
        }

        return new UserPrincipal(user);
    }
    
}
