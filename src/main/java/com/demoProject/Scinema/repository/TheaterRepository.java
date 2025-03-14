package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, String>
{
    @Query("SELECT t FROM Theater t WHERE t.theater_id in " + "(SELECT s.theater.theater_id FROM  Schedule s JOIN s.movie m WHERE s.movie.movie_id =: movieId)")
    List<Theater> getTheatersThatShowTheMovie(@Param("movieId") String movieId);
}
