package com.demoProject.Scinema.mapper;

import com.demoProject.Scinema.dto.reponse.ScheduleResponse;
import com.demoProject.Scinema.dto.request.ScheduleRequest;
import com.demoProject.Scinema.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper
{
    Schedule toSchedule(ScheduleRequest request);
    ScheduleResponse toScheduleResponse(Schedule schedule);
}
