package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.TicketResponse;
import com.demoProject.Scinema.mapper.TicketMapper;
import com.demoProject.Scinema.repository.TicketRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@RequiredArgsConstructor
public class TicketService implements ITicketService {

    TicketRepository ticketRepository;

    TicketMapper ticketMapper;

    @Override
    public List<TicketResponse> getTicketsByUserId(String userId) {
        return ticketRepository.findTicketsByUserId(userId)
                .stream().map(ticketMapper::toTicketResponse)
                .collect(Collectors.toList());
    }
}
