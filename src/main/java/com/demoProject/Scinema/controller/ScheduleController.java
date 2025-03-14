package com.demoProject.Scinema.controller;

import com.demoProject.Scinema.dto.reponse.ScheduleResponse;
import com.demoProject.Scinema.dto.request.ApiResponse;
import com.demoProject.Scinema.service.ScheduleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScheduleController
{
    ScheduleService scheduleService;

    @GetMapping("/start-times")
    public List<String> getStartTimes(@RequestParam String movieId, @RequestParam String theaterId, @RequestParam LocalDate startDate)
    {
        return scheduleService.getStartTimes(movieId, theaterId, startDate);
    }

    @GetMapping
    public ApiResponse<List<ScheduleResponse>> getSchedules(@RequestParam String movieId, @RequestParam String theaterId, @RequestParam String startDate, @RequestParam String startTime, @RequestParam String roomId)
    {
        return ApiResponse.<List<ScheduleResponse>>builder()
                .result(scheduleService.getSchedules(movieId, theaterId, startDate, startTime, roomId))
                .build();
    }
}
