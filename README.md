# spring-boot-102

Spring boot application with a GET and a POST requests. 

We are build an application that allows users to store api specifications.

POST url: `<host>/api/api-spec`
POST request:
* API = `<host>/api`
* METHOD = `GET, POST, PUT, DELETE`
* HEADERS = `{Authorization: "", hash: ""}`
* QUERY = `{userdata: {a: 1, b: 2}}`
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
mkdir -p ~Documents/projects/spring-boot-102/src/main/java
mkdir -p ~Documents/projects/spring-boot-102/src/main/resources
mkdir -p ~Documents/projects/spring-boot-102/src/main/tests
```
* Add a project management tool
`gradle init` creates the build.gradle. 
After this, we add the project dependencies and other information needed to identify the current projet.

Final build.gradle looks like this.

```
build.gradle should be pasted here
```

* Add data related library dependancies
```
show lines from build.gradle here
```

* Add a model object (this is basically a java class)
```
whole class definition in here
```

* Add a controller class (it is in charge of serving 2 restful API's)
```
whole class definition in here
```

