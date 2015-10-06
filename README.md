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
  mainClass = 'apispec.ApiSpecController'
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
touch src/main/java/apispec/ApiSpec.java
```
```
// ApiSpec.java - model object definition

package apispec;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApiSpec {

  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String api;
  private String method;
  private String headers;
	private String queryParams;

  public String getApi() {
		return api;
	}

	public String getMethod() {
		return method;
	}

  public String getHeaders() {
		return headers;
	}

	public String getQueryParams() {
		return queryParams;
	}

  public ApiSpec(String api, String method, String headers, String queryParams) {
    this.api = api;
    this.method = method;
    this.headers = headers;
    this.queryParams = queryParams;
  }
}
```

* Add a controller class (it is in charge of serving 2 restful API's)
```
cd ~/Documents/projects/spring-boot-102
touch src/main/java/apispec/ApiSpecController.java
```
```
// ApiSpecController.java - controller and application starter/entry point
package apispec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiSpecController {

  public static void main(String [] arguments){
    SpringApplication.run(ApiSpecController.class, arguments);
  }
}
```

* Add a repository class (it is in charge of data storage)
```
cd ~/Documents/projects/spring-boot-102
touch src/main/java/ApiSpecRepository.java
```
```
// ApiSpecRepository.java - repository for data storage
package apispec;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apispec", path = "apispec")
public interface ApiSpecRepository extends PagingAndSortingRepository<ApiSpec, Long> {

	List<ApiSpec> findByApi(@Param("api") String api);

}
```

* Build the application
```
gradle build
```
* Run the application
```
gradle bootRun
```
* Access the application from a web browser
```
http://localhost:8080/apispec
```

Resources:
* https://docs.gradle.org/current/userguide/build_init_plugin.html
* http://spring.io/guides/gs/accessing-data-rest
