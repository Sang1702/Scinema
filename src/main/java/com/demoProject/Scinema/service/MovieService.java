package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.MovieResponse;
import com.demoProject.Scinema.dto.request.MovieCreationRequest;
import com.demoProject.Scinema.entity.Movie;
import com.demoProject.Scinema.mapper.MovieMapper;
import com.demoProject.Scinema.repository.MovieRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@RequiredArgsConstructor
public class MovieService
{
    MovieRepository movieRepository;
    MovieMapper movieMapper;

    @PreAuthorize("hasRole('ADMIN')")
    public MovieResponse createMovie(MovieCreationRequest request)
    {
        Movie movie = movieMapper.toMovie(request);
        return movieMapper.toMovieResponse(movieRepository.save(movie));
    }

    public List<MovieResponse> getAllMovie()
    {
        return movieRepository.findAll().stream()
                .map(movieMapper::toMovieResponse)
                .toList();
    }

    public List<MovieResponse> getMovieByName(String movieName) {
        log.info("getMovieByName called");
        List<Movie> movies = movieRepository.findByName(movieName);
        return movies.stream()
                .map(movieMapper::toMovieResponse)
                .toList();
    }

    public MovieResponse getMovieById(String movieId)
    {
        log.info("getMovieById called");
        return movieMapper.toMovieResponse(movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("MOVIE NOT FOUND")));
    }

    public void deleteMovie(String movieId)
    {
        log.info("deleteMovie called");
        movieRepository.deleteById(movieId);
    }

}
