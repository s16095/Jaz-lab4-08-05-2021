package pl.pjatk.adrwoj.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {

        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable("id") int id) {
        List<Movie> movieList = movieService.getAll();
        Optional<Movie> movieOptional = movieList.stream().filter(m -> m.getId() == id).findFirst();
        if (!movieOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok(movieOptional);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie (@PathVariable("id") Long id, @RequestBody Movie movie){
        boolean validate = movieService.validateMovieModel(movie);
        if (!validate) return ResponseEntity.badRequest().build();
        Movie result = movieService.updateMovie(id, movie);
        if(result==null) return  ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
            Movie deletedMovie = movieService.deleteMovie(id);
            if(deletedMovie==null) return ResponseEntity.notFound().build();

            return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Movie> changeToTrue(@PathVariable Long id) {
         movieService.changeBoolean(id);
        return ResponseEntity.noContent().build();
    }
}
