package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.request.BookingRequestDTO;
import com.demoProject.Scinema.entity.Bill;
import com.demoProject.Scinema.entity.Schedule;
import com.demoProject.Scinema.entity.Ticket;
import com.demoProject.Scinema.entity.User;
import com.demoProject.Scinema.repository.*;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@RequiredArgsConstructor
public class BillService implements IBillService
{
    ScheduleRepository scheduleRepository;
    TicketRepository ticketRepository;
    UserRepository userRepository;
    SeatRepository seatRepository;
    BillRepository billRepository;


    @Override
    @Transactional
    public void createBill(BookingRequestDTO bookingRequestDTO) throws RuntimeException {
        Schedule schedule = scheduleRepository.findById(bookingRequestDTO.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        User user = userRepository.findById(bookingRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));


        //Lưu Bill gồm thông tin người dùng xuống trước
        Bill billToCreate = new Bill();
        billToCreate.setUser(user);
        billToCreate.setBuild_date(LocalDateTime.now());
        Bill createdBill = billRepository.save(billToCreate);

        //Với mỗi ghế ngồi check xem đã có ai đặt chưa, nếu rồi thì throw, roll back luôn còn ko
        //thì đóng gói các thông tin ghế và lịch vào vé và lưu xuống db
        bookingRequestDTO.getListSeats().forEach(seatId -> {
            if (!ticketRepository.findBySchedule_ScheduleIdAndSeat_SeatId(schedule.getSchedule_id(), seatId)
                    .isEmpty()) {// Nếu đã có người đặt vé ghế đó ở lịch cụ thể đó thì
                throw new RuntimeException("Đã có người nhanh tay hơn đặt ghế, mời bạn chọn lại!");
            }
            // đóng gói lịch, seat và bill vào từng vé rồi add vào list vé
            Ticket ticket = new Ticket();
            ticket.setSchedule(schedule);
            ticket.setSeat(seatRepository.getById(seatId));
            ticket.setBill(createdBill);
            ticketRepository.save(ticket);
        });
    }
}
