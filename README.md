# Spring
Spring Framework and Spring Boot by Telusko (Navin Reddy)

Covered Topics -
    Java
    JDBC
    Maven
    Spring Boot
    Spring Core (IoC)       (Inversion of Control)
    Spring ORM              (Object Relational Mapping)
    Spring MVC              (model-view-controller)
    Spring AOP              (Aspect-oriented Programming)
    Spring Data JPA         (Java Persistence API)
    Spring REST             (Representational State Transfer)
    Spring Security
    Docker
    Microservices

Notes -

Spring Boot works on Spring Framework.
Spring is used to develop applications.

    Jakarta Enterprice Beans (EJB; formerly Enterprise JavaBeans) is also such framework.
    For Web Applications -> STRUTS.
    We use Hibernate to work with databases with the help of ORM.

All the above can be done using Spring. Spring works on POJOs (Plain Old Java Objects). It is an ecosystem.

Prerequisites - 

Knowledge of -
    Core Java
    OOPS
    Exception Handling
    Threads
    Collection API
    JDBC (Java Database Connectivity)
    Build Tool (Maven or Graddle)
    Spring ORM (Hibernate also works)
    Servlets/ Spring MVS (Servlets are outdated, Spring MVC is used but MVC runs on a server such as TomCat which is a servlet container)

Tools -
    JDK
    IDE (VS Code, Eclipse, IntelliJ)
    Spring Tool 4 (formerly Spring Tool Suite)

IoC (Inversion of Control) Container - Control the flow of application, object creation. 
DI (Dependency Injection) - A design pattern for IoC. Used for injecting object/s within an object.

For creating even a simple code using Spring, we needed to -
1. Create the Project
2. Configure XML Files
3. Create the Beans
.
.
this is where springboot comes into picture, making things simpler

Springboot is an opinionated framework.

Any object created or managed by Spring are called Beans.

Scopes of beans -
1. Singleton    - used in Spring (default)
                - In Spring Framework, singleton objects are created the same number of times as defined in the spring.xml in resources folder (or wherever and whichever folder defined).
                - These are created on initializing the container.
                - Even if we have different references, the object remains the same if the id name is same.
                - constructors and setters are called upon container initialization

2. Prototype    - used in Spring (to be defined in xml)
                - created the same number of times as initializations of the object.
                - Not created on container initialization.
3. Request
4. Session

Types of injections (using AutoWired) - 

1. Field Injection
2. Constructor Injection
3. Setter Injection

If qualifier and primary, both are being used, qualifier will be preffered.

Client <--> Server <--> Database
Server has three layers - 
1. Controller - Sends and accepts requests. Works on model objects.
2. Service - Does the programming, logical operations, processings, etc.
3. Repository - Also called DAO (Data Access Object). It is responsible to interact with Database/Repository.

Apache TomCat is a Servlet/Web Container, needed to run servlets.
A console application needs a .jar (Java Archive) package whereas a web application needs a .war (Web Archive) package.

Types of HTTP Methods to interact with server using servlet -
1. Get (Get Data)
2. Post (Send Data)
3. Delete (Delete Data)
4. Put (Update Data)

JSP (Jakarta Server Pages, formerly JavaServer Pages) is a view technology, used to avoid java code getting bulky using HTML.
Some common view technologies include -
1. Thymeleaf
2. FreeMarker
3. Groovy Markup
4. Script Views
5. JSP and JSTL

Model View Controller (MVC) uses Objects (Models) to get the data. 
The flow being Client <-> Server (Controller [Servlet] -> Model [POJO] -> View [JSP]) <-> Database. 
Note: JSP is also called by the controller.
In Tomcat "Server/Servlet Container", the JSP is converted to Servlet to be able to run it.

Note: For Spring MVC, we need to configure Dispatcher Servlet in "web-app" in "webapp/WEB-INF/web.xml" -
<!-- 
<servlet>
    <servlet-name>telusko</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>telusko</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping> 
-->

telusko-servlet is necessary for Dispatcher Servlet to work find it in webapp/WEB-INF.

## spring-boot-rest and JOBPORTAL-1

Note: com.fasterxml.jackson.core:jackson-core is responsible for conversion of List<JobPost> to json
      com.fasterxml.jackson.dataformat:jackson-dataformat-xml is responsible for conversion of List<JobPost> to xml