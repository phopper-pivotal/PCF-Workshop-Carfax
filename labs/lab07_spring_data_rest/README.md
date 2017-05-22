# Spring Data REST

## we need Spring Boot's starter for Data REST
1. navigate to your project from lab 4
2. open the `pom.xml` from lab 4
3. add the following dependency
```xml
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
```

## expose our MovieRepository
1. add `@RepositoryRestResource` annotation to **_MovieRepository_**
   * add attribute `collectionResourceRel # "movies"` to @RepositoryRestResource annotation
   * add attribute `path # "movies"` to @RepositoryRestResource annotation
2. stop your previous version if it is still running
3. `./mvnw spring-boot:run`
4. visit http://localhost:8080/movies
5. follow the various links

## let their be data
1. we can see there's no data
   * POST data to the MovieRepository RESTful service
`curl -i -X POST -H "Content-Type:application/json" -d '{"title" : "Descpicalble Me", "year" : "2010", "rated" : "PG", "released" : "09 Jul 2010", "runtime" : "95 min" }'  http://localhost:8080/movies/`
2. visit http://localhost:8080/movies

## open the flood gates
1. let's preload some data
   * copy labs/lab5/import.sql to src/main/resources
   * stop your previous version if it is still running
2. `./mvnw spring-boot:run`
3. visit http://localhost:8080/movies
4. follow the various links

##  failed to search for you
1. let's fix search, in case you noticed there were errors
   * visit http://localhost:8080/movies/search/findByTitle?title#Minions
   * let's modify **_MovieRepository_**
       * add @Param("title") as in `List<Movie> findByTitle(@Param("title") String title);`
       * add @Param ("rated") as in `List<Movie> findByRated(@Param("rated") String rated);`
       * add @Param ("genre") as in `List<Movie> findByGenreStartsWith(@Param("genre") String genre);` 
2. `./mvnw spring-boot:run`
3. visit http://localhost:8080/movies/search/findByTitle?title#Minions

## pagination
1. let's enable pagination
   * change CrudRepository in **_MovieRepository_** to use PagingAndSortingRepository
   * change return type from List<Movie> to Page<Movie>
   * add extra argument to each findBy method as in `@Param("title") String title, Pageable pageable`
   * should now look like
```java
import io.pivotal.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel # "movies", path # "movies")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    Page<Movie> findByTitle(@Param("title") String title, Pageable pageable);

    Page<Movie> findByRated(@Param("rated") String rated, Pageable pageable);

    Page<Movie> findByGenreStartsWith(@Param("genre") String genre, Pageable pageable);

}
```

2. `./mvnw spring-boot:run`
3. visit http://localhost:8080/movies/
4. scroll to bottom of page to see pagination enabled
5. now visit http://localhost:8080/movies/search/findByGenreStartsWith?genre#Animation&sort#year
6. verify sort order by year movie was released

## cf push

1. repackage `./mvnw clean package`
2. create manifest.yml - be sure to change **_<your cf login>_** to that of your PCF login name
```yml
---
applications:
- name: watching-${random-word}
  buildpack: java_buildpack
  host: hello-$<your cf login>
  path: target/watching-0.0.1-SNAPSHOT.jar
```
3. push your app:  `cf push`
4. let's verify our changes
5. visit http://hello-your-random.yoursite.com/movies
6. visit http://hello-your-random.yoursite.com/movies/search/findByTitle?title#Minions
7. visit http://hello-your-random.yoursite.com/movies/search/findByGenreStartsWith?genre#Animation&sort#year