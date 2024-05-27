package com.ntr153.telusko;

import javax.servlet.Servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException 
    {
        System.out.println( "Hello World!" );

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);           // default is 8080

        Context context = tomcat.addContext("", null);      // (applicationName, directoryStructure) default -> ("",null)
        Tomcat.addServlet(context, "HelloServlet", (Servlet) new HelloServlet());   // context, servletName, servletObject
        context.addServletMappingDecoded("/hello", "HelloServlet");     // url, servletName (same as above)

        tomcat.start();
        tomcat.getServer().await();
    }
}