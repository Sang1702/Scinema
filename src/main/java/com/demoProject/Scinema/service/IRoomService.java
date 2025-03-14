package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.RoomResponse;

import java.time.LocalDate;
import java.util.List;

public interface IRoomService
{
    List<RoomResponse> getRooms(String movieId, String theaterId, String startDate, String startTime);
}
