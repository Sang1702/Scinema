package com.demoProject.Scinema.controller;

import com.demoProject.Scinema.dto.reponse.MovieResponse;
import com.demoProject.Scinema.dto.request.ApiResponse;
import com.demoProject.Scinema.dto.request.MovieCreationRequest;
import com.demoProject.Scinema.service.MovieService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MovieController
{
    MovieService movieService;

    @PostMapping
    ApiResponse<MovieResponse> createMovie(@RequestBody MovieCreationRequest request)
    {
        return ApiResponse.<MovieResponse>builder()
                .result(movieService.createMovie(request))
                .build();
    }

    @GetMapping("{name}")
    ApiResponse<List<MovieResponse>> getMovieByName(@PathVariable String name)
    {
        return ApiResponse.<List<MovieResponse>>builder()
                .result(movieService.getMovieByName(name))
                .build();
    }

    @GetMapping
    ApiResponse<List<MovieResponse>> getAllMovies()
    {
        log.info("getAllMovies called");
        return ApiResponse.<List<MovieResponse>>builder()
                .result(movieService.getAllMovie())
                .build();
    }

    @DeleteMapping("{movieId}")
    String deleteMovie(@PathVariable String movieId)
    {
        movieService.deleteMovie(movieId);
        return "Movie deleted";
    }
}
