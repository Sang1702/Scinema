package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.ScheduleResponse;
import com.demoProject.Scinema.mapper.ScheduleMapper;
import com.demoProject.Scinema.repository.ScheduleRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@RequiredArgsConstructor
public class ScheduleService implements IScheduleService
{
    ScheduleRepository scheduleRepository;

    ScheduleMapper scheduleMapper;

    @Override
    public List<String> getStartTimes(String movieId, String theaterId, LocalDate startDate)
    {
        return scheduleRepository.getStartTimeByMovieIdAndTheaterIdAndStartDate(movieId, theaterId, startDate)
                .stream().map(localTime -> localTime.format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleResponse> getSchedules(String movieId, String theaterId, String startDate, String startTime, String roomId) {
        return scheduleRepository.getSchedulesByMovieIdAndTheaterIdAndStartDateAndStartTimeAndRoomId(movieId, theaterId, LocalDate.parse(startDate), LocalTime.parse(startTime), roomId)
                .stream().map(scheduleMapper::toScheduleResponse)
                .collect(Collectors.toList());
    }
}
