package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    // Sử dụng @Query để truy vấn theo schedule_id
    @Query("SELECT t FROM Ticket t WHERE t.schedule.schedule_id = :scheduleId")
    List<Ticket> findBySchedule_ScheduleId(@Param("scheduleId") String scheduleId);

    // Sử dụng @Query để truy vấn theo schedule_id và seat_id
    @Query("SELECT t FROM Ticket t WHERE t.schedule.schedule_id = :scheduleId AND t.seat.seat_id = :seatId")
    List<Ticket> findBySchedule_ScheduleIdAndSeat_SeatId(@Param("scheduleId") String scheduleId, @Param("seatId") String seatId);

    @Query("SELECT t FROM Ticket t WHERE t.bill.bill_id IN (SELECT b.bill_id FROM Bill b WHERE b.user.user_id = :user_Id) ORDER BY t.ticket_id DESC")
    List<Ticket> findTicketsByUserId(@Param("user_Id") String user_Id);
}



