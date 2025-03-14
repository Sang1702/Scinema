package com.demoProject.Scinema.dto.reponse;

import com.demoProject.Scinema.dto.request.MovieCreationRequest;
import com.demoProject.Scinema.dto.request.RoomRequest;
import com.demoProject.Scinema.dto.request.TheaterRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ScheduleResponse
{
    String schedule_id;
    LocalDate start_date;
    LocalTime hourStart;
    Double price;;
    MovieResponse movieResponse;
    RoomResponse roomResponse;
    TheaterResponse theaterResponse;
}
