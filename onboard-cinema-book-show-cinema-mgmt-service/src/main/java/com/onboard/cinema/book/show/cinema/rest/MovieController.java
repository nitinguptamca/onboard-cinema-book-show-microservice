package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.Movie;
import com.onboard.cinema.book.show.cinema.repository.MovieRepository;
import jakarta.validation.Valid;
import java.time.Duration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping
    public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie){
        movie.setDuration(Duration.ofMinutes(movie.getDuration().toMinutes()));
        Movie movie1= movieRepository.save(movie);
        return new ResponseEntity<>(movie1, HttpStatus.CREATED);
    }
}
