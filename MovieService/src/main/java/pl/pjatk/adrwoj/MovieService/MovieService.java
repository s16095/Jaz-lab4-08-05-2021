package pl.pjatk.adrwoj.MovieService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies() {
        Movie movie1 = new Movie("some movie 1");
        Movie movie2 = new Movie("some movie 2");
        Movie movie3 = new Movie("some movie 3");

        return list.of(movie1, movie2, movie3);
    }
}
