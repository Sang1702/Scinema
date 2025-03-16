package com.demoProject.Scinema.dto.request;

import com.demoProject.Scinema.dto.reponse.BillDTO;
import com.demoProject.Scinema.dto.reponse.ScheduleResponse;
import com.demoProject.Scinema.dto.reponse.SeatResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TicketRequest
{
    String ticket_id;
    ScheduleResponse schedule;
    SeatResponse seat;
    BillDTO bill;
    Double price;
}
