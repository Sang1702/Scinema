package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    @Query("SELECT DISTINCT s.hourStart FROM Schedule s WHERE s.movie.movie_id = :movieId AND s.theater.theater_id = :theaterId AND s.start_date = :startDate")
    List<LocalTime> getStartTimeByMovieIdAndTheaterIdAndStartDate(
            @Param("movieId") String movieId,
            @Param("theaterId") String theaterId,
            @Param("startDate") LocalDate startDate);

    @Query("SELECT s FROM Schedule s WHERE s.movie.movie_id = :movieId AND s.theater.theater_id = :theaterId AND s.start_date = :startDate AND s.hourStart = :startTime AND s.room.room_id = :roomId")
    List<Schedule> getSchedulesByMovieIdAndTheaterIdAndStartDateAndStartTimeAndRoomId(
            @Param("movieId") String movieId,
            @Param("theaterId") String theaterId,
            @Param("startDate") LocalDate startDate,
            @Param("startTime") LocalTime startTime,
            @Param("roomId") String roomId);
}
