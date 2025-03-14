package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.TheaterResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITheaterService
{
    List<TheaterResponse> getTheatersThatShowTheMovie(@Param("movieId") String movieId);
}
