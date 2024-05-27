package com.ntr153.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/hello")        // for external tomcat
                                // also needs a web.xml containing url and corresponding servlet
public class HelloServlet extends HttpServlet {
    
    // public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {   // necessary method for processing

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        System.out.println("In Service");       // console

        res.setContentType("text/html");    // To declare we be using html, not plain text

        PrintWriter writeOut = res.getWriter();
        writeOut.println("<h2><b>Hello World</b></h2>");        // webPage
    }

}
