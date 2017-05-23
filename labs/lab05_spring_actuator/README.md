# Spring Boot Actuator

## pick up where we left off
1. navigate to your project from lab 4
   * alternatively, you can go to start.spring.io and
   * go through all the steps from lab 4
   * when you specify dependencies, add `actuator` and `HATEOAS`
![](lab2_boot.png)
2. assuming, you don't want to repeat yourself, open the pom.xml from lab 4
3. add the following 2 dependencies
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.hateoas</groupId>
    <artifactId>spring-hateoas</artifactId>
</dependency>
```
4. spring-boot-starter-actuator is the guts of all the actuator endpoints
5. spring-hateoas:
   * HATEOAS # Hypermedia As The Engine Of Application State
   * provides functionality for the /actuator endpoint to allow it to point to all the other endpoints
   * if you remove the hateoas dependency, actuator still works, you just don't get the /actuator endpoint itself

## run locally and explore
1. stop your previous version if it is still running
2. `./mvnw spring-boot:run`
3. visit http://localhost:8080/actuator
4. follow the various links
5. if you don't have the _JSONView_ chrome extension or something similar, consider installing it
6. alternatively
`curl http://localhost:8080/actuator`
7. there are [Production Ready Features](http://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html) of the endpoints

## cf push
1. repackage `./mvnw clean package`
2. push your app:  `cf push`
   * visit http://hello-your-random.yoursite.com/actuator
   * note some of the differences from your local version
3. traverse to Apps Manager and select your application
4. note the Spring Boot icon next to the app name
5. note the Git link below link "VIEW APP"
6. in the instance section of the app, in App Manager, expand the ">" to see the `/health` JSON

## extra credit
1. When certain requests come in, your app spins out of control.  Your support team is asking for thread and heap dumps.  Can you provide them without logging into the server and running commands from a shell?
2. Support would also like to see a dump of the last N requests to come in.
3. They would also like self-service access to the app's overall health when it isn't spinning out of control. What can you give them?
4. You think you might have left the "SPIN_OUT_OF_CONTROL_WHEN_CAT_VIDEOS_ARE_REQUSTED" environment variable set to true.  How can you validate the apps environment variables?
5. The /greeting endpoint doesn't seem to be mapped.  How can we determine all the endpoint mappings?

[Course Materials home](../../README.md#labs)

[Lab 6 - Spring Data REST](../lab06_spring_data_rest/README.md)
