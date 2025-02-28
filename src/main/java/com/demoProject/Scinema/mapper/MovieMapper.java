package com.demoProject.Scinema.mapper;

import com.demoProject.Scinema.dto.reponse.MovieResponse;
import com.demoProject.Scinema.dto.request.MovieCreationRequest;
import com.demoProject.Scinema.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper
{
    Movie toMovie(MovieCreationRequest request);
    MovieResponse toMovieResponse(Movie movie);
}
