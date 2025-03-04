package com.demoProject.Scinema.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String movie_id;
    String name;
    String language;
    String director;
    String actor;
    Integer duration;
    LocalDate release_date;

    @ElementCollection
    Set<String> genres;
}

