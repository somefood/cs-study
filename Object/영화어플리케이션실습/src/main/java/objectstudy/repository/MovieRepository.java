package objectstudy.repository;

import objectstudy.Movie;

import java.util.*;

public class MovieRepository {

    private Long movieId = 1L;

    private LinkedHashMap<Long, Movie> movieDict = new LinkedHashMap<>();

    public void save(Movie movie) {
        movieDict.put(movieId++, movie);
    }

    public Optional<Movie> findById(Long movieId) {
        return Optional.of(movieDict.get(movieId));
    }


    public LinkedHashMap<Long, Movie> findAll() {
        return (LinkedHashMap<Long, Movie>) movieDict.clone();
    }

    public LinkedHashMap<Long, Movie> getMovieDict() {
        return movieDict;
    }
}
