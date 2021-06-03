package pl.pjatk.adrwoj.MovieService;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
//
//    public MovieService(MovieRepository movieRepository) {this.movieRepository;}

    private List<Movie> movies = new ArrayList<Movie>();

    public List<Movie> getAll() {
        return this.movies;
    }

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.movies = this.getAllMovies();
    }

//    public List<Movie> getAllMovies() {
//        Movie movie1 = new Movie((long) 1, "Lord of the rings", EnumMovie.Fantasy, "Peter Jackson");
//        Movie movie2 = new Movie((long) 2, "Matrix", EnumMovie.Action, "Wachowsky Brothers");
//        Movie movie3 = new Movie((long) 3, "IT", EnumMovie.Horror, "Andy Muschietti");
//        Movie movie4 = new Movie((long) 4, "Star Wars", EnumMovie.Science_Fiction, "J.J. Abrams");
//        Movie movie5 = new Movie((long) 5, "Jumanji", EnumMovie.Adventure, "Joe Johnston");
//        Movie movie6 = new Movie((long) 6, "Seven", EnumMovie.Thriller, "David Fincher");
//        this.movies.add(movie1);
//        this.movies.add(movie2);
//        this.movies.add(movie3);
//        this.movies.add(movie4);
//        this.movies.add(movie5);
//        this.movies.add(movie6);
//
//        return this.movies;
//    }


    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
//        List<Movie> movieList = this.getAll();
//        OptionalLong lastId = movieList.stream().map(Movie::getId).mapToLong(x -> x).max();
//        if (lastId.isEmpty()) {
//            movie.setId(1L);
//        } else movie.setId(lastId.getAsLong() + 1L);
//        movieList.add(movie);
    }

//        List<Movie> movieList = this.getAll();
//        Optional<Movie> fromList = movieList.stream().filter(m -> m.getId() == id2).findFirst();
//        if (!fromList.isPresent()) return null;
//        else {
//            Movie result = fromList.get();
//            return result;
//        }

    public Movie deleteMovie(Long id) {
        Optional<Movie> result = movieRepository.findById(id);
        if (!result.isPresent()) return null;
        movieRepository.delete(result.get());
        return null;
    }

    public void changeBoolean (Long id){
        Optional<Movie> result = movieRepository.findById(id);
        if (!result.isPresent()) return;

        Movie resultMovie = result.get();

        resultMovie.setAvailable(true);
        movieRepository.save(resultMovie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Optional<Movie> result = movieRepository.findById(id);
        if (!result.isPresent()) return movie;

        Movie resultMovie = result.get();

        resultMovie.setName(movie.getName());
        resultMovie.setCategory(movie.getCategory());
        resultMovie.setAuthor(movie.getAuthor());

        movieRepository.save(resultMovie);
        return movie;
    }

    public boolean validateMovieModel(Movie movie) {
        if (movie.getName() == null || movie.getCategory() == null || movie.getAuthor() == null) return false;
        return true;
    }
}
