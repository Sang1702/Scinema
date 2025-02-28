package com.demoProject.Scinema.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MovieCreationRequest
{
    String name;
    String language;
    String director;
    String actor;
    Integer duration;
    LocalDate release_date;
    Set<String> genres;
}
