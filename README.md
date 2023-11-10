# Master Microservices with Spring Boot and Spring Cloud
---
> [!NOTE]
>
> Click [here](https://questglobal.udemy.com/course/microservices-with-spring-boot-and-spring-cloud) to go to Udemy Course Link.
>
> Click [here](https://github.com/in28minutes/spring-microservices-v3) to go to GitHub Link for course source code (spring-microservices-v3).
>
> Click [here](files/Spring-Microservices-CourseGuide.pdf) to check Course Guide PDF Document.

---
## What is Web Service?
```
W3C Definition: Software system designed to support interoperable machine-to-machine interaction over a network.
```

A web service is a set of open protocols and standards that allow data to be exchanged between different applications or systems. Web services can be used by software programs written in a variety of programming languages and running on a variety of platforms to exchange data via computer networks such as the Internet in a similar way to inter-process communication on a single computer.

Any software, application, or cloud technology that uses standardized web protocols (HTTP or HTTPS) to connect, interoperate, and exchange data messages – commonly XML (Extensible Markup Language) and JSON – across the internet is considered a web service.

## Why do we need a web service?
Web-based apps are developed using a range of programming platforms in today’s corporate world. Some applications are written in Java, others in .Net, and still others in Angular JS, Node.js, and other frameworks. Most of the time, these diverse programs require some form of communication to work together. Because they are written in separate programming languages, ensuring accurate communication between them becomes extremely difficult. Web services have a role in this. Web services provide a common platform for several applications written in different programming languages to connect with one another

## Spring Cloud Microservices Components
| Sl. No | Component | Example | Legacy
|-----:|-----------|----------|--------|
|     1| Discovery Server| Netflix Eureka| |
|     2| MS-MS Communication    | Fiegn Client | Rest Template, WebClient |
|     3| Circuit Breaker       | Resilience4j | Netflix Hystrix|
| 4 | API Gateway | Spring Cloud Gateway | Netflix Zuul |
| 5 | Distributed Logging | ELK, Sleuth | |
