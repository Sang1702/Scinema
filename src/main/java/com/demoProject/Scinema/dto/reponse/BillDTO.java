package com.demoProject.Scinema.dto.reponse;

import com.demoProject.Scinema.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillDTO
{
    String id;
    LocalDateTime date;
    List<TicketResponse> tickets;
    User user;
    double total_price;
    String status;
}
