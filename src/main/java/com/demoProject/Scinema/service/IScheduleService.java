package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.ScheduleResponse;
import java.time.LocalDate;
import java.util.List;

public interface IScheduleService
{
    List<String> getStartTimes(String movieId, String theaterId, LocalDate startDate);
    List<ScheduleResponse> getSchedules(String movieId, String theaterId, String startDate, String startTime, String roomId);
}
