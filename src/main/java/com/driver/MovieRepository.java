package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository

public class MovieRepository {

    HashMap<String,Movie> movieHashMap=new HashMap<>();
    HashMap<String,Director> directorHashMap=new HashMap<>();

    HashMap<Director, List<String>>  movieDirectorPairHashMap=new HashMap<>();
    MovieRepository(){

    }

    public void addMovie(Movie movie) {
       movieHashMap.put(movie.getName(), movie);


    }

    public void addDirector(Director director) {
        directorHashMap.put(director.getName(), director);

    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(movieDirectorPairHashMap.containsKey(directorHashMap.get(directorName))){

            movieDirectorPairHashMap.get(directorHashMap.get(directorName)).add(movieName);
        }else {
            List<String > temp=new ArrayList<>();
            temp.add(movieName);
            movieDirectorPairHashMap.put(directorHashMap.get(directorName),temp);

        }
    }

    public Movie getMovieByName(String movieName) {

        return movieHashMap.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return directorHashMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {

        return movieDirectorPairHashMap.get(directorHashMap.get(directorName));
    }

    public HashMap<String,Movie> findAllMovies() {

        return movieHashMap;
    }

    public void deleteDirectorByName(String directorName) {

        List<String> temp=movieDirectorPairHashMap.get(directorHashMap.get(directorName));

        for(String i:temp){
            movieHashMap.remove(i);
        }
        movieDirectorPairHashMap.remove(directorHashMap.get(directorName));
        directorHashMap.remove(directorName);

    }

    public void deleteAllDirectors() {
        directorHashMap.clear();
        for(Director i: movieDirectorPairHashMap.keySet()){
            List<String> temp=movieDirectorPairHashMap.get(i);
            for(String j:temp){
                if(movieHashMap.containsKey(j)){
                    movieHashMap.remove(j);
                }
            }
        }
        movieDirectorPairHashMap.clear();
    }
}
