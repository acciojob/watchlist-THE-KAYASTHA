package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    MovieService serviceObj=new MovieService();

@PostMapping("/add-movie")
public ResponseEntity<String> addMovie(@RequestBody Movie movie){

        serviceObj.addMovie(movie);
    return  new ResponseEntity<>("New movie added Successfully",HttpStatus.CREATED);

}

@PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){

        serviceObj.addDirector(director);
    return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
}

@PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,
                                                       @RequestParam String directorName){
            serviceObj.addMovieDirectorPair(movieName,directorName);

    return new ResponseEntity<>("New movie-director pair added successfully",HttpStatus.CREATED);

}


@GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam("movieName") String movieName){

        Movie movie=serviceObj.getMovieByName(movieName);
    return new ResponseEntity<>(movie,HttpStatus.CREATED);
}
@GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("directorName") String directorName){

    Director director=serviceObj.getDirectorByName(directorName);
    return new ResponseEntity<>(director,HttpStatus.CREATED);
}

@GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathParam("directorName") String directorName){

    List<String> moviesName=serviceObj.getMoviesByDirectorName(directorName);

    return new ResponseEntity<>(moviesName,HttpStatus.CREATED);

}

@GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> allMovies=serviceObj.findAllMovies();

        return new ResponseEntity<>(allMovies,HttpStatus.CREATED);
}
@DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){

        serviceObj.deleteDirectorByName(directorName);
        return new ResponseEntity<>(directorName+" removed successfully",HttpStatus.CREATED);

}
@DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>  deleteAllDirectors(){
    serviceObj.deleteAllDirectors();
    return new ResponseEntity<>("All directors removed successfully",HttpStatus.CREATED);

}


}
