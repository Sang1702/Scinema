package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.TheaterResponse;
import com.demoProject.Scinema.mapper.TheaterMapper;
import com.demoProject.Scinema.repository.TheaterRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@RequiredArgsConstructor
public class TheaterService implements ITheaterService{
    TheaterRepository theaterRepository;

    TheaterMapper theaterMapper;

    @Override
    public List<TheaterResponse> getTheatersThatShowTheMovie(String movieId) {
        return theaterRepository.getTheatersThatShowTheMovie(movieId)
                .stream().map(theaterMapper::toTheaterResponse)
                .collect(Collectors.toList());
    }
}
