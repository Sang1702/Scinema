package com.demoProject.Scinema.controller;

import com.demoProject.Scinema.dto.reponse.TheaterResponse;
import com.demoProject.Scinema.dto.request.ApiResponse;
import com.demoProject.Scinema.service.TheaterService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theaters")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TheaterController
{
    TheaterService theaterService;

    @GetMapping
    ApiResponse<List<TheaterResponse>> getTheatersThatShowTheMovie(@RequestParam String movieId)
    {
        return ApiResponse.<List<TheaterResponse>>builder()
                .result(theaterService.getTheatersThatShowTheMovie(movieId))
                .build();
    }
}
