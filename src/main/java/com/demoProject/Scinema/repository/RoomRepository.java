package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String>
{
    @Query("SELECT r FROM Room r WHERE r.room_id in (SELECT s.room.room_id FROM Schedule s WHERE s.movie.movie_id = :movieId AND s.theater.theater_id = :theaterId AND s.start_date = :startDate AND s.hourStart = :startTime)")
    public List<Room> getRoomByMovieIdAndTheaterIdAndSchedule(
            @Param("movieId") String movieId,
            @Param("theaterId") String theaterId,
            @Param("startDate") String startDate,
            @Param("startTime") String startTime
    );

}
