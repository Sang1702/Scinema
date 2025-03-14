package com.demoProject.Scinema.mapper;

import com.demoProject.Scinema.dto.reponse.TheaterResponse;
import com.demoProject.Scinema.dto.request.TheaterRequest;
import com.demoProject.Scinema.entity.Theater;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TheaterMapper
{
    Theater toTheater(TheaterRequest theaterRequest);
    TheaterResponse toTheaterResponse(Theater theater);
}
