package com.demoProject.Scinema.dto.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TheaterResponse
{
    String theater_id;
    String name;
    String address;
    String phone;
}
