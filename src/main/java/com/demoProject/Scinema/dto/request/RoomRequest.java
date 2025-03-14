package com.demoProject.Scinema.dto.request;

import com.demoProject.Scinema.entity.Theater;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RoomRequest
{
    String room_number;
    Integer capacity;
    Theater theater;
}
