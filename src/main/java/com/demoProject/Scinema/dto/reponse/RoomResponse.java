package com.demoProject.Scinema.dto.reponse;

import com.demoProject.Scinema.entity.Theater;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RoomResponse
{
    String room_id;
    String room_number;
    Integer capacity;
    Theater theater;
}
