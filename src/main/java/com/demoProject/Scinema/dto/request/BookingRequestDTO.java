package com.demoProject.Scinema.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDTO
{
    String userId;
    String scheduleId;
    List<String> listSeats;
}
