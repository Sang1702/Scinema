package com.demoProject.Scinema.mapper;

import com.demoProject.Scinema.dto.reponse.SeatResponse;
import com.demoProject.Scinema.dto.request.SeatRequest;
import com.demoProject.Scinema.entity.Seat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper
{
    Seat toSeat(SeatRequest seatRequest);
    SeatResponse toSeatResponse(Seat seat);
}
