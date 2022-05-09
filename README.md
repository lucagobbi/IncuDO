# IncuDO

IncuDO is an application to manage courses, helping migrants to find their career path and develop new skills. 
IncuDO is a mock project, part of the Java module of Start2Impact.

## Description

IncuDO is a small application written in Java, with a simple CLI. The aim is to fetch some data from some CSV external files and render them in the application as users, courses and reservations.
Once the app is initialized and data are fetched you can easily start to use some of the services provided, like viewing all courses, adding a new user, booking a course or deleting the reservation and even exporting data in a CSV file for external use!

## Dependencies
- Java SE 1.8
- Spring Boot 2.6.7
- opencsv 5.5

### Start up with JAR

In the target folder a JAR file is available: it includes all the dependencies and the source code to make the application run on every machine having a JRE installed.
Just download the JAR file, open a command prompt, navigate to the folder containing the JAR you have just downloaded and execute the following command:
```
java -jar testProgettoS2I-0.0.1-SNAPSHOT.jar
```

### Start up in IDE

If you want to compile the code in your IDE, just download the whole repository from Github and import a new Maven project in your IDE using the pom.xml provided for dependencies.

### Compile it by yourself

You could also compile and test the application by yourself: once you have downloaded and extracted the source code, open a cmd prompt and navigate to the project folder.
Since, this is a Maven project, be sure to have Maven configured on your system. Now you can launch:
```
mvn compile
```
Now you should be able to see all the compiled class in the target folder.

### Contacts

Email: lucasghegobbi@gmail.com
LinkedIn: www.linkedin.com/in/lucagobbi/

