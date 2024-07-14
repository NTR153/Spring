package com.ntr153.telusko.spring_sec_demo.security;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ntr153.telusko.spring_sec_demo.model.User;
import com.ntr153.telusko.spring_sec_demo.service.JwtService;
import com.ntr153.telusko.spring_sec_demo.service.MyUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.SecurityException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter { // once per request/service

    @Autowired
    private JwtService jwtService;

    // @Autowired
    // private MyUserDetailsService userDetailsService;    // this may cause cyclic dependency, hence getting the bean from application context

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7); // get jwt
                userName = jwtService.extractUserName(token);
            }

            // to avoid token validation if authentication is done already
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                // UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);
                    // fetch from db

                if (jwtService.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                            null, userDetails.getAuthorities());
                    // UsernamePasswordAuthenticationFilter is being used for authentication, hence
                    // UsernamePasswordAuthenticationToken
                    // Token only has details about the user
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // setting request object details to the token, to make it aware of the type of
                    // request
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    // setting the authentication token to the security holder
                }
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
