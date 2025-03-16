package com.demoProject.Scinema.service;


import com.demoProject.Scinema.dto.reponse.SeatResponse;

import java.util.List;

public interface ISeatService
{
    List<SeatResponse> getSeatByScheduleId(String scheduleId);
}
