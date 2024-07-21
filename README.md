# Spring
Spring Framework and Spring Boot by Telusko (Navin Reddy)

### Covered Topics -
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
    aws_web_app
        - System info web app for working with Elastic Beanstalk
    docker_rest_demo
        - Brief introduction to Docker, Images and Containers
    docker_student_app
        - Using Docker Compose for Student app and Postgres database containers
    java
        - Jdbc implementation
    jobapp
        - Working with Thymeleaf and Introduction to Views
    JOBPORTAL-1
        - React UI for embedded and Oracle database
        Note: search by keyword not working
    JOBPORTAL-2
    ormbapp
        - Working of Springboot application, replicating ormb
    servlet1
        - Http servlet functioning using jakarta servlet api and embedded Apache Tomcat
    spring-boot-rest
        - Implementing model, controller, service, repo (both - normal and JPA based)
        - Also used by JOBPORTAL-1
        - Aspect Oriented Programming introduced
        - Worked with AWS RDS, ECR and ECS
    spring-data-jpa
        - interface repo implements JpaRepository (DSL)
    spring-data-rest
        - Working with Postman and RestController
    spring-oauth-demo
        - Google and Github OAuth2 based project
    spring-sec-demo
        - Spring Security implemented using web, devtools    
    spring1
        - Xml based and Class configuration for Spring Framework
        - Used Alien, Computer, Desktop, Laptop like classes
    springboot1
        - Springboot functionalities utilized for spring1
    springbootweb1
        - Thymeleaf introduced
    springmvc1
        - Working with Model View Controller

### Notes -

Spring Boot works on Spring Framework.
Spring is used to develop applications.

Jakarta Enterprice Beans (EJB; formerly Enterprise JavaBeans) is also such framework.
For Web Applications -> STRUTS.
We use Hibernate to work with databases with the help of ORM.

All the above can be done using Spring. Spring works on POJOs (Plain Old Java Objects). It is an ecosystem.

Prerequisites 

    Knowledge of
        - Core Java
        - OOPS
        - Exception Handling
        - Threads
        - Collection API
        - JDBC (Java Database Connectivity)
        - Build Tool (Maven or Graddle)
        - Spring ORM (Hibernate also works)
        - Servlets/ Spring MVS (Servlets are outdated, Spring MVC is used but MVC runs on a server such as TomCat which is a servlet container)

    Tools
        - JDK
        - IDE (VS Code, Eclipse, IntelliJ)
        - Spring Tool 4 (formerly Spring Tool Suite)

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

    1. Singleton
        - used in Spring (default)
        - In Spring Framework, singleton objects are created the same number of times as defined in the spring.xml in resources folder (or wherever and whichever folder defined).
        - These are created on initializing the container.
        - Even if we have different references, the object remains the same if the id name is same.
        - constructors and setters are called upon container initialization

    2. Prototype
        - used in Spring (to be defined in xml)
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

Note: For Spring MVC, we need to configure Dispatcher Servlet in "web-app" in "webapp/WEB-INF/web.xml"
    <servlet>
        <servlet-name>telusko</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    </servlet>
    ...
    <servlet-mapping>
        <servlet-name>telusko</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping> 

telusko-servlet is necessary for Dispatcher Servlet to work find it in webapp/WEB-INF.

### spring-boot-rest and JOBPORTAL-1

Note: com.fasterxml.jackson.core:jackson-core is responsible for conversion of List<JobPost> to json
      com.fasterxml.jackson.dataformat:jackson-dataformat-xml is responsible for conversion of List<JobPost> to xml

There can be multiple ways to work with Database -

1. Normal JDBC

2. Spring JDBC (embedded)

3. Spring ORM (lot of coding)

    - ORM -> Object Relational Mapping.
    - Used for mapping objects to tables.
    - Hibernate, Toplink, Eclipse Link are few of ORM tools.
    - Spring ORM and Hibernate both implements JPA.

4. Spring Data JPA (easiest) -
    - JPA -> Java Persistence API.
    - JPA is a specification that allows switching between ORM tools easily.
    - Spring Data JPA uses Hibernate.
    - JPA uses JPQL (JPA Query Language) for custom queries.
    - It also uses DSL (Domain Specific Language) for creating queries behind the scene, such as equals or greater than and less than.
            Which are defined in the Custom Repo Interface (which extends JpaRepository<objectName, primaryIdentifierDataType>).
    
Note: for oracle sql database, the code sets list data as -
        C##NTR153.STRINGARRAY('Core Java', 'J2EE', 'Spring Boot', 'Hibernate') instead of
        {'Core Java', 'J2EE', 'Spring Boot', 'Hibernate'}  (plsql example from the course)
        C##NTR153 being the userName. This maybe Database Vendor (oracleSql) specific    

Types of Databases
    a. Relational (Oracle SQl, PSQL)
    b. NoSQL (eg. Cassandra -> uses CQL i.e. Cassandra Query Language, MongoDb)

Types of Programmings
    a. OOP - Object Orientend Programming
    b. AOP
        - Aspect Oriented Programming (Compliments OOP), overcomes cross-cutting concerns i.e. concerns appearing at multiple places
        - AOP can be used for logging, security, validations, transaction management.

AOP Concepts (comparing with a movie)

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

### Spring Security - spring-sec-demo

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

### JWT - spring-sec-demo

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

### OAuth - spring-oauth-demo

##### Open Authorization (OAuth) - 
    - OAuth is basically verifying the user using third party such as Google
    - Current version is OAuth2
    - behind the scene, OAuth2 Client implements Spring Security. Hence, we get a login form by default
    
##### Google OAuth Creation
    - in order to have a Google OAuth login in our page, we need to 
    - Create a custom SecurityFilterChain
    - Go to https://cloud.google.com/cloud-console/
    - Try It Free/Go To Console
    - Three bars
    - APIs and services
    - OAuth consent screen, set consent
    - Credentials
    - Web Application, set project name
    - Add Authorized redirect URIs to http://localhost:8080/login/oauth2/code/google
    - Create
    - Copy Client ID and Client secret
    - set these in application.properties

##### Github OAuth Creation
    - Go to Github
    - settings
    - Developer settings
    - OAuth Apps
    - Application name
    - Homepage url -> http://localhost:8080
    - Authorization callback URL -> http://localhost:8080/login/oauth2/code/github
    - Register application
    - copy the client id
    - Generate a new client secret
    - set these in application.properties

### Docker - docker_rest_demo

##### Virtualization

    - Having a Hypervisor that manages Virtual Hardware and installs Guest OS on top of Stock OS
    - eg. Hardware -> Host OS (Windows) -> Hypervisor (VM Ware) -> Guest OS (Ubuntu)
    - In order to share the application/s, configurations, etc. we share the virtual os directly as an image file, so need to configure or setup explicitly in every application
    - We can also have multiple OS's on same Hypervisor (Virtual Hardware), this is required when we need to have same application multiple times and avoid communication b/w them
    - In order to tackle having to export whole os, we have:

##### Containerization

    - Hardware -> Host OS -> Docker -> Container/s
    - example for containers include docker, podman
    - provides safety, portability, consistency, speed, scalability

##### Docker

    - Docker engine, used for creating and managing containers, as user interaction
    - provides containers, img of containers to export/transfer configs and apps
    - docker file is used to create the img
    - For storage, docker has Volumes
    - Containers have their networking components

##### Docker Hub

    - Compilers, Web Servers, Applications, etc. for Docker are available on docker hub

##### Docker Compose

    - To have application running on multiple containers

##### Docker Architecture

    - Docker Client (part of docker) <-> Docker (includes daemon (dockerd), images, containers, network components, volumes) <-> Registry    

##### Docker Command line

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

    specific to openjdk 
        - docker exec {contaner_name} ls -a                     -> lists all the folders within jdk

        Steps for creating an image with command "java -jar /tmp/docker_rest_demo.jar"
            
            - docker cp {relative_jar_path} {container_name}:/tmp   -> copies jar to currently running containers' tmp folder
            - docker commit {container_name} {image_name}:{tag}     -> creates .img for the container, tag is version
            - docker commit -c='CMD ["java","-jar","/tmp/docker_rest_demo.jar"]' {container_name} {image_name}:{v1}
                    -> change default command from jshell to running the springboot project for image being saved
            - docker run {ntr153/telusko/docker_rest_demo}:{v1}         -> run the project

        If above method does not work, in order to update the jar -> create a docker file (see Dockerfile for reference) and run

            - docker build -t ntr153/telusko/docker_rest_demo:v1 .
                    This command tells Docker to build an image from the Dockerfile in the current directory (.)
            - docker run -p 8080:8080 ntr153/telusko/docker_rest_demo:v1
                    This will expose the docker port to the machine port

    - docker exec -it {container_name} bash                             -> to get interactive cmd for the container
    - docker image inspect {ntr153/telusko/docker_rest_demo}:{v1}       -> inspect image

### Docker Compose - docker_student_app

    - Helps with running multiple containers for a single project
    - for docker compose configuration, we need docker-compose.yml
    - we also need to edit credentials in application.properties within the project and make it same as docker-compose config

    - mvn clean package
    - mvn clean package -DskipTests -> skips tests
    - docker-compose up --build     -> to build the image, based on dockerfile
    - docker-compose down           -> to remove containers created by the image, based on dockerfile

    - docker exec -it docker_student_app-postgres-1 bash    -> to enter interactive mode of postgres container
    - psql -U telusko -h localhost -p 5432                  -> to enter psql

### Cloud

##### Cloud Computing
    - Cloud is a combination of multiple services
    - eg. AWS, Microsoft Cloud, Google Cloud, Azure, WillHat, IBM.

##### Elastic Cloud Computing
    - Resources/servers expand on requirement

##### On-Premise

    On Local Machine
        - Functions
        - Applications
        - Runtime and containers
        - Operating Systems and management tools
        - Networking, storage and servers
        - Data Centre

##### IaaS (Infrastructure)

    On Local Machine
        - Functions
        - Applications
        - Runtime and containers
        - Operating Systems and management tools
    
    On Service Provider end
        - Networking, storage and servers
        - Data Centre

##### CaaS (Container)

    On Local Machine
        - Functions
        - Applications
        - Runtime and containers
    
    On Service Provider end
        - Operating Systems and management tools
        - Networking, storage and servers
        - Data Centre

##### PaaS (Platform)

    On Local Machine
        - Functions
        - Applications
    
    On Service Provider end
        - Runtime and containers
        - Operating Systems and management tools
        - Networking, storage and servers
        - Data Centre

##### FaaS (Function)

    On Local Machine
        - Functions
    
    On Service Provider end
        - Applications
        - Runtime and containers
        - Operating Systems and management tools
        - Networking, storage and servers
        - Data Centre

##### SaaS (Software)

    On Service Provider end
        - Functions
        - Applications
        - Runtime and containers
        - Operating Systems and management tools
        - Networking, storage and servers
        - Data Centre

##### Private Cloud

    - By default, any cloud is a public cloud, i.e. anyone can access the cloud. 
    - There can be security risks in case of sensitive data. eg. banks, finances
    - To resolve this, we have private cloud that a company has under within it's wall
    - Advantage - Security, Drawback - Cost beacause now, we have to manage the servers, data centres, everything

##### Hybrid Cloud

    - Some data on private cloud, some on public cloud

##### AWS

    - EC2 (Elastic Computing) (IaaS)
    - Elastic Beanstalk (PaaS). This uses EC2 behind the scene
    - Elastic Kubernetes Service, Elastic Container Service (AWS based, simpler than EKS) (CaaS)
    - Elastic Container Registry (For storing Docker Images)
    
##### IAM (Identity and Access Management)

    - Used to avoid using root account, to create a sub account
    - Need to create User Group (dev1) -> User (ntr153_telusko)

##### Elastic Beanstalk

    - We'll be creating an Elastic Beanstalk project (aws_web_app)
    - For this, we'll need a role under IAM. Role created as ec2Role having "AdministratorAccess", "AdministratorAccess-AWSElasticBeanstalk"
    - default port number for Elastic Beanstalk is 5000, hence changed the port number for project as well

    Project Creation
        - Go to Elastic Beanstalk
        - Create Project
        - Environment tier -> Web server environment
        - Application name -> aws_web_app
        - Platform -> Managed Platform, Java (for jar). For war, we need to select tomcat
        - Application code, Upload your code, Version Lable -> v1, Local file
        - Presets -> Single Instance
        - Next
        - Existing service role -> ec2Role
        - EC2 Instance Profile -> ec2Role, Next
        - Skip To Review
        - Submit
        - Launch the created website

##### RDS (Relational Database Service)

    - We'll be using spring-boot-rest project for this
    - RDS service is used to create a database
    - We have to change the databsource url in application.properties after creation of the database
    - Also change port no to 5000

    Creating RDS Database
        - IAM login
        - RDS
        - Create Database
        - Standard Create, Postgres (cannot use Oracle because it is chargeable), Default Engine Version
        - Templates -> Free Tier, DB instance identifier -> postgreSQL-DB
        - Master username -> postgres, Credentails Management -> Self managed
        - Auto generate password or manual password -> ntr153_telusko
        - Public Access -> Yes
        - Create Database

        Note: Single db must be in use at a time else, we may be charged

        Solution for "connection timeout" in pg admin - https://stackoverflow.com/questions/52324170/aws-rds-for-postgresql-cannot-be-connected-after-several-hours

            For the error of "connection timeout", one of the reasons can be from the security settings. Although set as public when creating the RDS instance, the instance is attached with a private VPC security group which is not exposed publicly.

            We can attach the RDS instance with a public security group inside the VPC (just for learning purpose) as below:

            - from Services, select EC2, select Security Groups in the left panel.
            - click "Create Security Group" button.
            - in the dialog, enter the name for the Group, e.g "postgres-public-access"
            - if you have several VPC's, make sure in the last dropdown that you select the same VPC that your database is in
            - in the dialog, click "Add Rule" button.
            - In the "Type" column, select "PostgreSQL" or other types of RDS instances (or you can input the port of your RDS instance, - usually it is 5432 for Postgres).
            - In the "Source" column, enter "0.0.0.0/0".
            - Click "Save" button.
            - from Services, select RDS, select the RDS instance, click "Modify" button.
            - In "Network & Security", "Security group", select the VPC Security Group you just created, in my case, it is "postgres-public-access".
            - Click "Continue" button. Now you can go ahead and connect with your database everywhere.

##### AWS CLI

    Configuration
        - Install AWS CLI for Windows
        - In AWS Developer Console (website), Go To IAM -> Users -> select user -> Create Access Key -> Select Use Case as CLI -> Submit
        - Copy Access Key and Secret Access Key
        - Open Cmd
        - $ aws configure
        - enter access key, secret access key, enter (for default region), enter (for default format)
        - Check configuration by using
        - $ aws iam list-users

##### ECS (Elastic Container Service)
    
    Cluster Creation
        - Go to ECS
        - Create Cluster
        - Cluster name -> aws-springboot-rest, Infrastructure -> AWS Fargate (need not have explicit configurations and server management)
        - Create

    Creating Task 1 (postgres DB)
        - Go to Cluster
        - Go to Task Definitions
        - Create new Task Definition, Create new task definition, Task definition family name -> aws-springboot-rest-task-db, Infrastructure Requirements -> AWS Fargate, Task Role -> None
        - Container 1 Name -> postgres, Image URI -> postgres:latest
        - Add port mapping [5432 | TCP | postgres-port | HTTP]
        - Add Environment Variables,
            POSTGRES_DB | telusko
            POSTGRES_USERNAME | postgres
            POSTGRES_PASSWORD | ntr153_telusko
        - Create
        - In Json tab, we get json. Using such json, we can create a task

    Running Task 1
        - Go to Cluster
        - Go to Tasks
        - Run new Task
        - Compute Option -> Launch type, Launch Type -> Fargate
        - Application Type -> Task, Family -> aws-springboot-rest-task-db
        - Networking -> Keep VPC default, Security Group -> Create a new security group -> aws-springboot-rest-task-db-access
        - Type -> All traffic, Source -> Anywhere
        - Public IP -> Turned On
        - Create
        - Go to Task
        - Copy Public IP Address
        - Configure the same in project application.properties

##### ECR (Elastic Container Registry)

    - AWS CLI configuration is needed
    - We need to put the image/s in ECR and pull them to ECS and run

    ECR Repository Creation and image upload
        - Go to ECR
        - Create a Repository
        - Visibility Settings -> Private
        - Repository name -> springboot-rest-job-app-image
        - Create
        - View push commands
        - Copy the commands (We can use macOs/Linux command)
        - mvn clean package -DskipTests
        - Create the dockerfile
        - Run the commands in your project path configured cmd window.

        Note:
            If above method for creating and pushing the image to AWS ECR does not work (very unlikely), try below method
            $aws ecr get-login-password --registry-ids <your-registry-name>
                provides a token for the registry in the form 
                    Username: AWS
                    Password: <long-base64-encoded-password>
                    ExpiresIn: 12h0m0s
                that can be used for authenticating docker client to the aws registry using
            $docker login -u AWS -p <password-from-previous-step> <your-registry-name>.dkr.ecr.<region>.amazonaws.com
            $docker tag <your-local-image-name> <your-ecr-registry-uri>:<tag-name>
            $docker push <your-ecr-registry-uri>:<tag-name>

        - Now, we will have an image in our repository
        - Copy Image URI (this will be needed for running application task in ECS)

##### ECS (Continued)

    Creating Task 2 (main application)
        - Go to Cluster
        - Go to Task Definitions
        - Create new Task Definition, Create new task definition, Task definition family name -> aws-springboot-rest-task-main,
        Infrastructure Requirements -> AWS Fargate, Task Role -> None
        - Container 1 Name -> job-app-container-java, Image URI -> previously copied URI
        - Add port mapping [5000 | TCP | web-port | HTTP]
        - Create

    Running Task 1
        - Go to Cluster
        - Go to Tasks
        - Run new Task
        - Compute Option -> Launch type, Launch Type -> Fargate
        - Application Type -> Task, Family -> aws-springboot-rest-task-main
        - Networking -> Keep VPC default, Security Group -> Create a new security group -> aws-springboot-rest-task-db-access
        - Type -> All traffic, Source -> Anywhere
        - Public IP -> Turned On
        - Create
        - Go to Task
        - Go To Public IP -> IpAddress:PortNo (http://13.127.77.43:5000)