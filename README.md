# PCF-Workshop-Carfax
This workshop will focus on the Pivotal Cloud Foundry Developer persona. We will review details about how to push an application, scaling, services, logging and metrics.

## Goals of Workshop
* Focus on application code
* Easy and quick deployment; no lengthy exchanges with ops
* Greater control over deployment
* Quick and timely updates to production
* Creating applications that are optimized for the cloud

## Outcomes of Workshop
* Comfort with cf command line tools and deploying to PCF
* Increased familiarity with operations and the platform
* Ability to configure and provision services
* Understanding of using PCF for logging and metrics

## Agenda

### Overview
* PCF Overview and Cloud Native Architecture (with labs)
* Spring for PCF (Boot, Actuator, Data / REST)
* PCF Installation (click-through install)
* Day 2 Operations (RBAC, Scaling, Health, Updates/Patching, Auth)

### Details
Time | Session
---- | -------
9:00 AM - 9:30 AM | _Session 1: Cloud Native Architectures & Frameworks_
9:30 AM - 11:00 AM | _Session 2: Pivotal Cloud Foundry Overview with Labs*_
11:00 AM - 12:00 PM | _Session 3: Spring Boot, Profiles and Actuator with Labs*_
12:00 PM - 1:00 PM | _Lunch_
1:00 PM - 2:00 PM | _Session 4: Spring Data / REST on Cloud Foundry with Labs*_
2:00 PM - 3:00 PM | _Session 5: Installing Pivotal Cloud Foundry_
3:00 PM - 4:00 PM | _Session 6: Pivotal Cloud Foundry Day 2 Operations_
4:00 PM - 4:30 PM | _Wrap-up, Q&A, What's next?_

This is a _loose_ schedule for the day. We will adjust as necessary based on our pace through the material.

The lectures for this workshop are generally light and are only intended to set the stage for the hands-on labs.
The overwhelming majority of our time will be spent engaging with the technology directly!

## Labs
* Pre-work
  * From Zero to Pushing Your First Application
* Spring Boot
* Spring Profiles
* Spring Actuator
* Spring Data
* Spring Data REST
* Monitoring Your Application
* Operating Your Application

## Getting Started
### Pre-requisites
Start by downloading and installing the appropriate prerequisite tools.
- [Cloud Foundry CLI](https://goo.gl/M0pH4i) to interact with a cloud foundry instance
- [Apache Maven](http://info.pivotal.io/HI002010A6ZlRJR1NeU00eC) to build labs using Maven
- [Gradle](https://services.gradle.org/distributions/gradle-3.1-all.zip) to build labs using Gradle
- [Git Client](https://git-scm.com/downloads) to clone Github repo or download and unzip
- An IDE, like [Spring Tool Suite](https://spring.io/tools/sts/all) or [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Java SE Development Kit version 8](http://info.pivotal.io/n0I60i3021AN0JU0le10CRR)

### Download Materials
Next, download the course materials. This can be accomplished either through the GitHub website by downloading a repository zip and unzipping locally, or if you have Git installed, use the following commands:
```
$ git clone https://github.com/phopper-pivotal/PCF-Workshop-Carfax
Cloning into 'PCF-Workshop-Carfax'...
remote: Counting objects: 374, done.
remote: Total 374 (delta 0), reused 0 (delta 0), pack-reused 374
Receiving objects: 100% (374/374), 90.87 MiB | 13.65 MiB/s, done.
Resolving deltas: 100% (78/78), done.

$ cd PCF-Workshop-Carfax/
```

### PCF Environments
Finally, in order to perform the labs, you must be connected or logged into a live PCF environment. Initially you were asked to create a Pivotal Web Services (PWS) account for use in labs and afterwards. Two other environments have also been made available for use. Please see the [Pivotal Cloud Foundry Environment document](Common/env_info.md) for details. You should have been assigned a student number and PCF instance at registration. Otherwise the instructors will provide that information for your use.

### Instructors
* Chris Busch, Pivotal Platform Architect, cbusch@pivotal.io
* Paul Hopper, Pivotal Platform Architect, phopper@pivotal.io

