package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String>
{
    List<Movie> findByName(String name);
    boolean existsById(String movieId);
}
