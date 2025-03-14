package com.demoProject.Scinema.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TheaterRequest
{
    String name;
    String address;
    String phone;
}
