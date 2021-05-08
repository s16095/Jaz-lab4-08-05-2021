package pl.pjatk.adrwoj.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/test")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieController movieController) {
        this.movieService = movieService;
    }

    @GetMapping("/models")
    public ResponseEntity<List<Car>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }
}
