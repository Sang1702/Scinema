package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String>
{
    @Query("SELECT s FROM Seat s WHERE s.room.room_id = :room_id")
    List<Seat> getSeatByRoom_Room_Id(String room_id);

}
