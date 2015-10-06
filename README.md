# spring-boot-102

Spring boot application with a GET and a POST requests. 

We are build an application that allows users to store api specifications.

POST url: `<host>/api/api-spec`
POST request:
* API = `<host>/api`
* METHOD = `GET, POST, PUT, DELETE`
* HEADERS = `{Authorization: "", hash: ""}`
* QUERY_PARAMS = `{userdata: {a: 1, b: 2}}`
POST response:
* Saved object

GET url: `<host>/api/api-spec/<id>`
GET request:
* ID = `object id`
GET response:
* Saved specified by the id

Technology:
* [Gradle](https://gradle.org/)
* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring Data](http://projects.spring.io/spring-data/)

Steps followed:
* create the application structure (on *nix machines)
```
mkdir -p ~/Documents/projects/spring-boot-102/src/main/java
mkdir -p ~/Documents/projects/spring-boot-102/src/main/resources
mkdir -p ~/Documents/projects/spring-boot-102/src/test
```
* Add a project management tool
```
cd ~/Documents/projects/spring-boot-102
gradle init
```
`gradle init` creates the build.gradle. 
After this, we add the project dependencies and other information needed to identify the current projet.

Final build.gradle looks like this.

```
buildscript {
     repositories {
         mavenCentral()
     }
     dependencies {
         classpath("org.springframework.boot:spring-boot-gradle-plugin:1.2.6.RELEASE")
     }
 }
apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'spring-boot'

springBoot {
  mainClass = 'ApiSpecController'
}
jar {
    baseName = 'spring-boot-102'
    version =  '0.0.1'
}

repositories {
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile 'org.springframework.boot:spring-boot-starter-data-rest'
    compile 'org.springframework.boot:spring-boot-starter-data-jpa'
    compile 'com.h2database:h2'

    compile 'org.slf4j:slf4j-api:1.7.12'
    testCompile 'junit:junit:4.12'
}

task wrapper(type: Wrapper) {
    gradleVersion = '2.7'
}
```

* Add data related library dependancies
```
org.springframework.boot:spring-boot-starter-data-rest
org.springframework.boot:spring-boot-starter-data-jpa
```

* Add a model object (this is basically a java class)
```
cd ~/Documents/projects/spring-boot-102
touch src/main/java/ApiSpec.java
```
```
// ApiSpec.java
whole class definition in here
```

* Add a controller class (it is in charge of serving 2 restful API's)
```
cd ~/Documents/projects/spring-boot-102
touch src/main/java/ApiSpecController.java
```
```
// ApiSpecController.java
whole class definition in here
```

* Add a repository class (it is in charge of data storage)
```
cd ~/Documents/projects/spring-boot-102
touch src/main/java/ApiSpecRepository.java
```
```
// ApiSpecRepository.java
whole class definition in here
```
