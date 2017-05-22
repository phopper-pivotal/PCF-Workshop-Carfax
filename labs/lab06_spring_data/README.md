# Lab 4: Spring Data

## let's build an entity
1. navigate to start.spring.io
2. configure your project
   * group name (use **_'io.pivotal'_**')
   * artifact name (use **_'watching'_**)
   * *_maven_* for your build system
   * spring boot version 1.4.1
4. add dependencies
   *  Web
   *  JPA
   *  H2
   *  Actuator
5. select 'Generate Project'
6. unzip the downloaded file
7. open your favorite IDE
   *  import project root
   *  java 8, use by default (if not installed, go download. god speed)
8. open pom.xml - what starters are there?
9. create package io.pivotal.domain
10. create class *_Movie_*
    *  add `@Entity` (javax.persistence.Entity) annotation to class
    *  add attributes 
       *  title
       *  year
       * rated
       *  released
       *  runtime
       *  genre
       * add an attribute, generated value for movie identifier
```java
@Id
@GeneratedValue
private long id;
```

   *  use IDE to generate getter/setter methods
   *  use IDE to generate a default constructor void of and attributes as arguments
   *  use IDE to generate a constructor that takes all attributes as arguments
   *  use IDE to generate a toString method
       *  your code should look something like this
```java
package io.pivotal.domain;

@Entity
@Table(name#"movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String year;

    private String rated;

    private String released;

    private String runtime;

    private String genre;

    public Movie() {}

    public Movie(String title, String year, String rated, String released, String runtime, String genre) {
        this.title # title;
        this.year # year;
        this.rated # rated;
        this.released # released;
        this.runtime # runtime;
        this.genre # genre;
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id # id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title # title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year # year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated # rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released # released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime # runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre # genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id#" + id +
                ", title#'" + title + '\'' +
                ", year#'" + year + '\'' +
                ", rated#'" + rated + '\'' +
                ", released#'" + released + '\'' +
                ", runtime#'" + runtime + '\'' +
                ", genre#'" + genre + '\'' +
                '}';
    }    
}
```

## now expose the entity through a repository
1. create package io.pivotal.repositories
2. create interface **_MovieRepository_**
   *  add `extends CrudRepository<Movie, Long>` to the interface
   *  add method `List<Movie> findByTitle(String title);` to the interface

## a CommandLineRunner is our friend
1. let's load this entity backed by H2 with data
  *  add the code below to WatchingApplication class 
```java
    @Bean
    public CommandLineRunner demo(MovieRepository movieRepository) {
        return (args) -> {
            // save a couple of movies
            movieRepository.save(new Movie("Frozen", "2013", "PG", "27 Nov 2013", "102 min", "Animation, Adventure, Comedy"));
            movieRepository.save(new Movie("Toy Story", "1995", "G", "22 Nov 1995", "81 min", "Animation, Adventure, Comedy"));
            movieRepository.save(new Movie("Muppets Most Wanted", "2014", "PG", "21 Mar 2014", "107 min", "Adventure, Comedy, Crime"));
            movieRepository.save(new Movie("The Incredibles", "2004", "PG", "05 Nov 204", "115 min", "Animation, Action, Adventure"));

            // fetch all movies
            System.out.println("Movies found with findAll()");
            System.out.println("---------------------------");
            for (Movie movie : movieRepository.findAll()) {
                System.out.println(movie.toString());
            }


            // fetch one movie
            System.out.println("Movies found with findOne()");
            System.out.println("---------------------------");
            Movie movie # movieRepository.findOne(1L);


            // fetch movies by title
            System.out.println("Movies found with findByTitle('Frozen')");
            System.out.println("---------------------------");
            for (Movie frozen : movieRepository.findByTitle("Frozen")) {
                System.out.println(frozen.toString());
            }

        };
    }
```
2. from project root directory, run `mvn sprint-boot:run`

what just happened?

how much boilerplate code did we have to introduce?

## can we query by other attributes
1. let's add some other methods to retrieve our movies
   *  add a method to **_MovieRepository_** to findByRated
```java
List<Movie> findByRated(String rated);
```
  *  add code to the CommandLineRunner in *_WatchingApplication_* to output findByRated
  
```java
// fetch movies by rated
System.out.println("Movies found with findByRating('G'");
System.out.println("---------------------------");
System.out.println(movieRepository.findByRated("G").toString());
System.out.println();
```
2. from project root directory, run `mvn sprint-boot:run` +

what just happened?

## that's great but what about wildcards
1. let's add some wildcard method to retrieve where genre starts with "Animation"
2. add a method findByGenreStartsWith to *_MovieRepository_*
```java
List<Movie> findByGenreStartsWith(String genre);
---------------------------------------------------------------------
```
3. add code to the CommandLineRunner in *_WatchingApplication_* to output findByRated
```java
// fetch movies by rated
System.out.println("Movies found with findByGenreStartsWith('Animation'");
System.out.println("---------------------------");
movieRepository.findByGenreStartsWith("Animation").forEach(genres -> System.out.println(genres));
```
4. from project root directory, run `mvn sprint-boot:run` +
isn't this just awesome, only need to add a single method to expose the data

no longer embedding queries to my datastore

no longer handling JDBC connections or JDBCTemplate or EntityMangerFactories

no longer using @NamedQueries

no longer using prepared statements

# extra credit
given we can use methods on the *_MovieRepository_* to retrieve data what other ways can you query for wildcards + 

[shhh here's a hint](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)

[Course Materials home](../../README.md#course-materials)

[Lab 7 - Spring Data REST](../lab06_spring_actuator/README.md)