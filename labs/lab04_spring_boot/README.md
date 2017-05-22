# Lab 1: Spring Boot Basics

## run locally
1. visit link:http://start.spring.io[start.spring.io]
![](../../Common/imageslab1_boot.png)
2. configure your project
  * group name
  * artifact name (*_'hello'_* is recommended)
  * *_maven_* for your build system
  * spring boot version 1.5.3
3. add dependencies
  * Web
4. 'Generate Project'
5. unzip the downloaded file
6. open in IDE or cd to project directory for vim/emacs
7. open pom.xml - notice the spring starters
8. create class: `HelloController` in same directory as the Boot app class
  * annotate the class with `@RestController` (package: `org.springframework.web.bind.annotation`)
  * create method: `public String sayHello() { return "Hello World"; }`
  * annotate the method with: `@RequestMapping("/")` (package: `org.springframework.web.bind.annotation`)
  * Your source should look something like this:
```java
 package bootworkshop.pivotal.io;

 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * Created by rhardt on 9/21/16.
  */
 @RestController
 public class HelloController {

     @RequestMapping("/")
     public String sayHello(){
         return "Hello DISH!";
     }

 }
```


9. from project root directory, run `mvn spring-boot:run`
10. point a web browser to http://localhost:8080
11. bask in the glory that is Spring Boot

## push to Pivotal Cloud Foundry
1. make sure you have all of your link:/Spring-Workshop-Dish/pre-requisites/Spring_Boot_Labs_Setup.html[prerequisites] in place.
2. build a runnable jar `./mvnw package`
3. log in to cloud foundry `cf login -a api.yourpcfsystem.com`
4. when prompted, provide your email and password
5. if prompted, choose an appropriate org and space
6. push your app:  `cf push hello -p ./target/hello-0.0.1-SNAPSHOT.jar -n "hello-rob" -b java_buildpack`
  * instead of 'hello-rob' give your app a unique route (the `-n` option)
  * depending on what you called your app, the runnable jar (the `-p` option) may be different
  * watch the output, it will tell you the url of your app
```
Creating app hello in org Vertical / space rhardt-sandbox as rhardt@pivotal.io...
OK

Creating route hello-rob.cfapps.io...
OK

Binding hello-rob.cfapps.io to hello...
OK
```
7. open a web browser to the route of your app - from the output of the `cf push`
8. celebrate
9. silently complain about the so-un-2016-uber-long command you must issue to push to Cloud Foundry
10. stop complaining and put it in a manifest.yml at the top level of your project
```yml
---
applications:
- name: hello
  buildpack: java_buildpack
  host: hello-${random-word}
  path: target/hello-0.0.1-SNAPSHOT.jar
```
11. `cf push`
12. `cf apps` will show you all the deployed apps in your space along with their vital stats and mapped routes.  Notice the random words from the manifest file.
```
$ cf apps
Getting apps in org Vertical / space rhardt-sandbox as rhardt@pivotal.io...
OK

name                  requested state   instances   memory   disk   urls
ep-shell              started           1/1         128M     1G     ep-shell.cfapps.io
hello                 started           1/1         1G       1G     hello-rob.cfapps.io, hello-unscaled-multimillion.cfapps.io
```
13. verify your app at its new randomly-generated route

# extra credit
1.  Why `@RestController`?
2. Allows you to return strings, but also enables some interesting features
3. Add this class to your HelloController.java file:
```java
class Greeting {
    private String message;
    private String greeting;
    private boolean happyToSeeYou;

    //constructor, getters, setters omitted for brevity

}
```
4.  and add this method:
```java
    @RequestMapping("/greeting")
    public Greeting greet() {
        return new Greeting("Hello", "DISH", true);
    }
```
5. now `cf push` and visit http://hello-random-words.yourhost.com/greeting
6. marvel at your newfound speed and productivity