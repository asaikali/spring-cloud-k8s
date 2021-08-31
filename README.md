# spring-cloud-k8s

A sample repo showing how to use Spring Cloud on Kubernetes. The samples use Spring Boot 2.5.1 
and Spring Could 2020.0.3.  Samples include a readme.md file with interesting things 
to try out.


## Software Prerequisites

The sample application instructions assume you have docker desktop with kubernetes running in it, this is very helpful
because it allows us to create container images and run them without having to publish them to a remote repo.

You will need the following installed on your laptop to try out the samples in this repo.  

* [Java 11 JDK](https://adoptopenjdk.net/)
* Favourite Java IDE [Eclipse Spring Tool Suite](https://spring.io/tools) or [IntelliJ](https://www.jetbrains.com/idea/download)
* [Docker](https://www.docker.com/products/docker-desktop)
* [Octant](https://github.com/vmware-tanzu/octant#installation)
* [kustomize](https://kustomize.io/) 
* [Kubernetes](https://kubernetes.io/) sample tested with Docker Desktop K8s. If you have a different k8s install you must know how to expose the app in k8s to your machine  if you don't just use docker desktop k8s to run these demos.

### Validate your Environment

* Clone the repo
* Test your docker desktop Kubernetes using `kubectl get nodes` and you should see 1 node. On my machine
  I get the result below.
```
NAME             STATUS   ROLES    AGE   VERSION
docker-desktop   Ready    master   14d   v1.19.3
```
* run the `octant` command you should see a browser popup, you will land in the octant UI. 

