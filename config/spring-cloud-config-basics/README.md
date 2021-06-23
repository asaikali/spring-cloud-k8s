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

* Fork [https://github.com/practical-microservices/spring-cloud-config-basics-repo.git](https://github.com/practical-microservices/spring-cloud-config-basics-repo.git) into your own Git repo on GitHub
* Import the root of the repo into your favorite Java IDE
* Edit to `config-server\src\main\resources\application.yml` to point to your fork from step 1
* Run config-server application
* Run `billboard` application
* visit `http://127.0.0.1:8082/actuator/env` to see how the application is getting its setting
* visit `http://localhost:8888/billboard/master` to see the settings for configuring billboard app
* Run `greeter` application
* visit `http://127.0.0.1:8080/actuator/env` to see how the application is getting its setting
* visit `http://localhost:8880/billboard/master` to see the settings for configuring greeter app
* visit `http://localhost:8880/billboard/actuator/health` to see the settings for configuring greeter app

### Things to try out 
* Access each application and check how the message is mapping to configuration value associated with every app. Examine the config repo to see how the mapping works. Notice that the name of the yml file matches the application name configured under `spring.application.name`
* Change the Spring profile of billboard application to `dev` and see how the message is affected - the new values is coming out of configuration file `billboard-dev.yml`
* Access the `/health` endpoint of each app. Notice how the configuration defined in `application.yml` applies to both applications.

### Deploy to Kubernetes

*Validate env* 
* Make sure docker desktop is running on your machine with k8s service running. If you are using a remote k8s cluster
   you will need to adapt the instructions to publish images to a registry accessible from your cluster. 
* Install the [kustomize cli](https://kustomize.io/) if you don't have it installed

*Deploy the app*
* build the container images locally using spring boot plugin `./mvnw clean spring-boot:build-image`.
* deploy the app `kustomize build . | kubectl apply -f -`
* check contents of the config-server namespace `kc get all -n config-server` you will see the node ports of all the 
  services for the greeter, billboard, and config server. Output should be similar to the one below.
  
```txt
 kc get all -n config-server
NAME                                 READY   STATUS    RESTARTS   AGE
pod/billboard-678dd95f76-g5shb       1/1     Running   0          94s
pod/config-server-68458bdd86-d2swz   1/1     Running   0          5h37m
pod/greeter-6f876888c9-bt2l9         1/1     Running   0          5h7m

NAME                    TYPE       CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
service/billboard       NodePort   10.101.120.196   <none>        8080:30542/TCP   5h2m
service/config-server   NodePort   10.101.66.131    <none>        8888:30055/TCP   5h39m
service/greeter         NodePort   10.104.246.64    <none>        8080:31709/TCP   5h17m

NAME                            READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/billboard       1/1     1            1           5h2m
deployment.apps/config-server   1/1     1            1           5h39m
deployment.apps/greeter         1/1     1            1           5h7m

NAME                                       DESIRED   CURRENT   READY   AGE
replicaset.apps/billboard-5cdb9cf846       0         0         0       5h2m
replicaset.apps/billboard-678dd95f76       1         1         1       94s
replicaset.apps/config-server-6494b469d8   0         0         0       5h39m
replicaset.apps/config-server-68458bdd86   1         1         1       5h37m
replicaset.apps/greeter-6f876888c9         1         1         1       5h7m

```
* Take note of the node port of the config-server and go to `http://localhost:replace-with-node-port-number/billboard/master`
* visit the node port of the billboard and config services you will see the same behaviour you saw when you ran the samples
  on your laptop.
* inspect the yaml files for the deployment open the `kustomization.yaml` and inspect the various yaml deployments, 
  notice how the deployment manifest sets the environment variables. 
  
### Resources to Learn More:
* https://cloud.spring.io/spring-cloud-config/