package com.demoProject.Scinema.mapper;

import com.demoProject.Scinema.dto.reponse.TicketResponse;
import com.demoProject.Scinema.dto.request.TicketRequest;
import com.demoProject.Scinema.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper
{
    Ticket toTicket(TicketRequest ticketRequest);
    TicketResponse toTicketResponse(Ticket ticket);
}
