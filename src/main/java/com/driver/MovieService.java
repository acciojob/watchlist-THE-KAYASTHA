package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service

public class MovieService {

    MovieService(){

    }
    MovieRepository repoObj=new MovieRepository();
    public Movie getMovieByName(String movieName) {
        Movie movie=repoObj.getMovieByName(movieName);
        return movie;

    }

    public Director getDirectorByName(String directorName) {
        Director director=repoObj.getDirectorByName(directorName);
        return director;
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        List<String> moviesName=repoObj.getMoviesByDirectorName(directorName);
        return moviesName;
    }

    public List<String> findAllMovies() {

        HashMap<String,Movie> temp=repoObj.findAllMovies();

        List<String > ans=new ArrayList<>();

        for(String i: temp.keySet()){
            ans.add(i);
        }
        return ans;
    }

    public void deleteDirectorByName(String directorName) {

        repoObj.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors() {
        repoObj.deleteAllDirectors();
    }

    public void addMovie(Movie movie) {

        repoObj.addMovie(movie);

    }

    public void addDirector(Director director) {
        repoObj.addDirector(director);

    }

    public void addMovieDirectorPair(String movieName, String directorName) {

        repoObj.addMovieDirectorPair(movieName,directorName);
    }

}
