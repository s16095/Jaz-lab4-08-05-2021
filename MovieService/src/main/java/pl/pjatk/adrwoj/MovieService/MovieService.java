package pl.pjatk.adrwoj.MovieService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies() {
        Movie movie1 = new Movie(1, "Lord of the rings", EnumMovie.Fantasy, "Peter Jackson");
        Movie movie2 = new Movie(2, "Matrix",EnumMovie.Action, "Wachowsky Brothers");
        Movie movie3 = new Movie(3, "IT",EnumMovie.Horror, "Andy Muschietti");
        Movie movie4 = new Movie(4, "Star Wars",EnumMovie.Science_Fiction, "J.J. Abrams");
        Movie movie5 = new Movie(5, "Jumanji",EnumMovie.Adventure, "Joe Johnston");
        Movie movie6 = new Movie(6, "Seven",EnumMovie.Thriller, "David Fincher");

        return List.of(movie1, movie2, movie3, movie4, movie5, movie6);
    }
}
