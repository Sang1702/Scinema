package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.TicketResponse;

import java.util.List;

public interface ITicketService
{
    List<TicketResponse> getTicketsByUserId(String userId);
}
