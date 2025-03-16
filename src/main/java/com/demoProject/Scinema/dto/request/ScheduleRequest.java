package com.demoProject.Scinema.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ScheduleRequest
{
    LocalDate start_date;
    LocalTime hourStart;
    Double price;;
    MovieCreationRequest movieCreationRequest;
    RoomRequest roomRequest;
    TheaterRequest  theaterRequest;
}
