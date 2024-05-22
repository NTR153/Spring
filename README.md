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

If qualifier and primary, both are being used, qualifier will be preffered