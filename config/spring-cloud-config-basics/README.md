# Spring Cloud Config Basics

### Overview

This sample shows off how one can use Spring Cloud Config Server can externalize configuration of each application. 
It also showcases ways that one can create configurations that target different environments and overriding 
configuration values based on application profiles. 

*Spring Boot 2.4 changed how bootstrap configuration works, the billboard app uses Spring Boot 2.4+ approach to
configuration, and the greeter app uses the Spring Boot 2.3 approach by turning on legacy processing mode see*
* [Changes Spring Boot 2.4 introduced](https://www.youtube.com/watch?v=lgyO9C9zdrg&t=1489s)
* [Config file processing in Spring Boot 2.4](https://spring.io/blog/2020/08/14/config-file-processing-in-spring-boot-2-4)

### Run the Demo

* Fork https://github.com/practical-microservices/spring-cloud-config-basics-repo.git into your own Git repo on GitHub
* Import the root of the repo into your favorite Java IDE
* Edit to `config-server\src\main\resources\application.yml` to point to your fork from step 1
* Run config-server application
* Run `billboard` application
* Run `greeter` application
 

### Things to try out 
* Access each application and check how the message is mapping to configuration value associated with every app. Examine the config repo to see how the mapping works. Notice that the name of the yml file matches the application name configured under `spring.application.name`
* Change the Spring profile of billboard application to `dev` and see how the message is affected - the new values is coming out of configuration file `billboard-dev.yml`
* Access the `/health` endpoint of each app. Notice how the configuration defined in `application.yml` applies to both applications.

 
### Resources to Learn More:
* https://cloud.spring.io/spring-cloud-config/