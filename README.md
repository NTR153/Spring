# Spring
Spring Framework and Spring Boot by Telusko (Navin Reddy)

#### Covered Topics -
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

### Projects - 
    java - Basic, manual jdbc implemented
    jobapp - views introduced
    JOBPORTAL-1 - React UI for fake db (within project) and real db (oracleSQL) via springboot application/s
        Note: Note: search by keyword not working
    JOBPORTAL-2
    ormbapp - basic working of springboot application, trying to replicate ormb
    servlet1 - basic http servlet functioning using jakarta servlet api and embedded Apache Tomcat
    spring-boot-rest - implementing model, controller, service, repo (both - normal and JPA based). Also used by JOBPORTAL-1.
                    Aspect Oriented Programming introduced
    spring-data-jpa - removed service, used methods provided by JpaRepository (DSL) for Student table. 
    spring-data-rest - Job App accessed using Postman.
    spring1 - used spring framework with both - xml based configuration and configuration class.
        Used Alien, Computer, Desktop, Laptop like classes.
    springboot1 - utilized springboot functionalities for above (spring1) project.
    springbootweb1 - a thymeleaf based web project
    springmvc1 - exploring model view controller
    spring-sec-demo - spring security demo using web, devtools

### Notes -

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
    <servlet>
        <servlet-name>telusko</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>telusko</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping> 

telusko-servlet is necessary for Dispatcher Servlet to work find it in webapp/WEB-INF.

##### spring-boot-rest and JOBPORTAL-1

Note: com.fasterxml.jackson.core:jackson-core is responsible for conversion of List<JobPost> to json
      com.fasterxml.jackson.dataformat:jackson-dataformat-xml is responsible for conversion of List<JobPost> to xml

There can be multiple ways to work with Database -
1. Normal JDBC
2. Spring JDBC (embedded)
3. Spring ORM (lot of coding) - 
    ORM -> Object Relational Mapping.
    Used for mapping objects to tables.
    Hibernate, Toplink, Eclipse Link are few of ORM tools.
    Spring ORM and Hibernate both implements JPA.
4. Spring Data JPA (easiest) -
    JPA -> Java Persistence API.
    JPA is a specification that allows switching between ORM tools easily.
    Spring Data JPA uses Hibernate.
    JPA uses JPQL (JPA Query Language) for custom queries.
    It also uses DSL (Domain Specific Language) for creating queries behind the scene, such as equals or greater than and less than.
            Which are defined in the Custom Repo Interface (which extends JpaRepository<objectName, primaryIdentifierDataType>).
    Note: for oracle sql database, the code sets list data as -
            C##NTR153.STRINGARRAY('Core Java', 'J2EE', 'Spring Boot', 'Hibernate') instead of
            {'Core Java', 'J2EE', 'Spring Boot', 'Hibernate'}  (plsql example from the course)
            C##NTR153 being the userName. This maybe Database Vendor (oracleSql) specific    

Types of Databases - 
    a. Relational
    b. NoSQL (eg. Cassandra -> uses CQL i.e. Cassandra Query Language, MongoDb)

OOP - Object Orientend Programming
AOP - Aspect Oriented Programming (Compliments OOP), overcomes cross-cutting concerns 
            i.e. concerns appearing at multiple places
    - AOP can be used for logging, security, validations, transaction management.

AOP Concepts (comparing with a movie) -
    - Join Point (When) eg. function load
    - Advice (What) eg. logging
    - Aspect (Where-Conceptual) eg. in a LoggingAspect class
    - Pointcut (Where-Operational) this is Join Points (scenes) where Advice (plot twists) happen. It's like a bookmark.
    - Target Object (Whom)
    - Weaving (How) this happens at runtime. AspectJ based AOP goes into compile time
    - Proxy (The Double)
    - Type of Advice (The Genre)
        - Before
        - After (finally)
        - After Returning (try)
        - After Throwing (exception)
        - Around (before and after) eg. to check time for execution

For Aspect concepts, check spring-boot-rest/aspects

OWASP (Open Web Application Security Project) Top 10 - Top 10 attacks
- A01 Broken Access Control
- A02 Cryptographic Access
- A03 Injection
- A04 Insecure Design
- A05 Security Misconfiguration
- A06 Vulnerable and Outdated Components
- A07 Identification and Authentication Failures
- A08 Software and Data Integrity Failures
- A09 Security Logging and Monitoring Features
- A10 Server Side Request Forgery (SSRF)

##### Spring Security - spring-sec-demo

Spring Security
    - is used for having login form for the url, default username being "user" and password autogenerated.
    - password is present in the logs (Using generated security password: ...)
    - we can also logout using localhost:8080/logout
    - after logging in with the password, we get a session id in Inspect -> Network -> Name -> Headers -> Cookie
        this session id is responsible for not having to login for every link within application and a new tab
    - username and password can be configured in application.properties

CSRF (Cross-Site Request Forgery)
    - A session id specific hack, eg. a malicious site fetches session id from the browser cookies and tries to login
        with same session id on other device.
    - Spring Security takes care of CSRF for PUT, DELETE and UPDATE methods but not GET as it cannot change anything
        on the server.
    - Spring Security provides a CSRF token, necessary for above methods using postman (X-CSRF-TOKEN) in header.
    - Method to get CSRF token -
        @GetMapping("csrf-token")
        public CsrfToken getCsrfToken(HttpServletRequest request) {
            return (CsrfToken) request.getAttribute("_csrf");
        }
    - CSRF issue can also be avoided by using same site property in application.properties

REST API states - 
1. Stateless - Different Session Id/s, avoiding CSRF possibility.
             We have to send the username and password everytime.
2. Statefull - Same Session Id throughout

Custom Security Filters added in securityFilterChain() in SecurityConfig for stateless REST API

Users configured in userDetailsService() in SecurityConfig

For authorizing user credentials based on a db table, we will be using JPA and Oracle SQL.
In order to do that, we need to change Authentication Provider that authorizes Authentication Object.
Authentication Provider will be connecting with Oracle SQL using DAO (Data Access Object) layers.
    This configuration is done in authenticationProvider() in SecurityConfig,
    return object being DaoAuthenticationProvider,
    which needs "UserDetailsService daoUserDetailsService" for setUserDetailsService(),
    for which we have created MyUserDetailsService (which implements UserDetailsService),
    which returns UserPrincipal (which implements UserDetails interface), that is expected return type for loadUserByUsername,
    for which we have created a "UserRepo" jpa repo and "User" jpa entity

Password Encoding Types -
1. Cryptography 
    - encrypt at one end, transfer the encrypted text, decrypt it at other end.
    - two way encryption
    - it the key/conversion is compromised, all the passwords may be compromised.
    - key types

    a. Symmetric Key
        - same key present with sender and receiver
        - Algorithms like AES (Advanced Encryption Standard) and DES (Data Encryption Standard)
        - great for private communication, a key per communication.

    b. Asymmetric Key
        - Encrypt data using private and decrypt using public key and vice versa.
        - Algorithms like RSA (Rivest, Shamir, Adleman) and ECC (Elliptic Curve Cryptography)
        - greate for public communication or communication in a group
        - risk of data being changed in whole and encrypted by public key.
        - digital signature avoids this by verifying the identity from which the data is coming using senders private key. Here, we achieve identity but loose security.
        - to tacke all of the above problems,
            A encrypts the data using:
                B's public key
                A's private key
            and B decrypts it using:
                A's public key
                B's private key

2. Hashing - one way encryption
        - MD5, SHA256 are some of the hashing algorithms

3. Bcrypt - hashing algorithm implemented multiple times
       - example "0000" converted to "$2a$10$rcGi4YuowO3TCS9OEBa2xO9k8Sqykaeom1ZqIKLcsnko2/Zuy0g5e"
       - $2a meaning the version of bcrypt.
       - $10 meaning the number of hashing rounds. 2^10 rounds actually.
       - we have done this in UserService

##### JWT - spring-sec-demo

Note: Having a session id in cookies only may not be feasible in scaled server model
      For tackling this,
        We can either ask the loadbalancer to provide access to the client for processing on any server or
        We can have a db storing session id/s for user or
        We can use JWT instead

JWT (Json Web Token)
    - a signed token/pass given to the client to interact with any server from the a scaled server model after a successful login.
    - can be an XML or JSON, also has expire dttm
    - algorithms include HS... (only one secret key), RS... (private and public key) for client and server
    - io.jsonwebtoken.jjwt-api (api) and io.jsonwebtoken.jjwt-impl (implementation) and io.jsonwebtoken.jjwt-jackson (json conversion) to be used for creating jwt in the project spring-sec-demo
    - try "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJudHIxNTMiLCJpYXQiOjE3MjA5MDUwNTYsImV4cCI6MTcyMDkwNTIzNn0.wq0xKCeElqxPiemgCjj0zQJ5JGZArsRxoZqjDxYnidY" as Encoded text, with Algorithm HS256 on https://jwt.io/ to visualize the token.
    - properties related to jwt are called claims (Check io.jsonwebtoken.Claims)

    - KeyGenerator is used to create a secret key, encode it and that again is used to generate a token in JwtService
        The token is returned as a string in the login method and the same token can be used to access services.

    - need to have a once per request filter JwtFilter to validate the token and authorize the request

#### OAuth - spring-oauth-demo

Open Authorization (OAuth) - 
    - OAuth is verifying the user using third party such as Google
    - Current version is OAuth2
    - behind the scene, OAuth2 Client implements Spring Security. Hence, we get a login form by default
    
    - in order to have a Google OAuth login in our page, we need to create a custom SecurityFilterChain and go to https://cloud.google.com/cloud-console/ -> Try It Free/Go To Console -> Three bars -> APIs and services -> OAuth consent screen (set consent) -> Credentials -> Web Application, set project name, Add Authorized redirect URIs to http://localhost:8080/login/oauth2/code/google -> Create -> Copy Client ID and Client secret -> set these in application.properties

    - for Github OAuth login -> Go to Github -> settings -> Developer settings -> OAuth Apps -> configure Application name, homepage url (http://localhost:8080), Authorization callback URL (http://localhost:8080/login/oauth2/code/github) -> Register application -> copy the client id -> Generate a new client secret -> set these in application.properties

#### Docker

Virtualization
    - Having a Hypervisor that manages Virtual Hardware and installs Guest OS on top of Stock OS
    - eg. Hardware -> Host OS (Windows) -> Hypervisor (VM Ware) -> Guest OS (Ubuntu)
    - In order to share the application/s, configurations, etc. we share the virtual os directly as an image file, so need to configure or setup explicitly in every application
    - We can also have multiple OS's on same Hypervisor (Virtual Hardware), this is required when we need to have same application multiple times and avoid communication b/w them
    - In order to tackle having to export whole os, we have:

Containerization
    - Hardware -> Host OS -> Docker -> Container/s
    - example for containers include docker, podman
    - provides safety, portability, consistency, speed, scalability

Docker
        - Docker engine, used for creating and managing containers, as user interaction
        - provides containers, img of containers to export/transfer configs and apps
        - docker file is used to create the img
        - For storage, docker has Volumes
        - Containers have their networking components

    Docker Hub
        - Compilers, Web Servers, Applications, etc. for Docker are available on docker hub

    Docker Compose
        - To have application running on multiple containers

Command line -
    - docker run {image_name}     -> checks for the image locally, if not present downloads it from docker hub, creates a 
                                        container, runs it
    - docker search {image_name}  -> searches on docker hub
    - docker pull {image_name}    -> downloads the image
    - docker images               -> list of images
    - docker create {image_name}  -> creates a container for the image
    - docker start {container_id} -> starts the container
    - docker ps                   -> to get active containers
    - docker pause {container_id} -> pause the container
    - docker stop {container_id}  -> stops the container
    - docker ps -a                -> all containers that ran previously
    - docker rm {container_id}    -> removes container, container id changes every run
    - docker rmi {image_id}       -> removes image
    - docker help                 -> get help
    - docker run -it {image_id}   -> to run an image in interactive mode eg. running jshell using openjdk.
                                        image_name:version can also be used for the command

Docker Architecture
    - Docker Client (part of docker) <-> Docker (includes daemon (dockerd), images, containers, network components, volumes) <-> Registry
