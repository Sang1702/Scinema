package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.SeatResponse;
import com.demoProject.Scinema.entity.Room;
import com.demoProject.Scinema.entity.Seat;
import com.demoProject.Scinema.mapper.SeatMapper;
import com.demoProject.Scinema.repository.ScheduleRepository;
import com.demoProject.Scinema.repository.SeatRepository;
import com.demoProject.Scinema.repository.TicketRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@RequiredArgsConstructor
public class SeatService implements ISeatService
{
    SeatRepository seatRepository;

    SeatMapper seatMapper;

    ScheduleRepository scheduleRepository;

    TicketRepository ticketRepository;

    @Override
    public List<SeatResponse> getSeatByScheduleId(String scheduleId) {
        // Lấy ra phòng của lịch đó
        Room room = scheduleRepository.getById(scheduleId).getRoom();

        // Lấy ra các ghế của phòng trong lịch đó
        List<Seat> seatList = seatRepository.getSeatByRoom_Room_Id(room.getRoom_id());

        // Lấy ra các vé đã được đặt trong lịch đó và chuyển thành danh sách các ghế đã chiếm
        List<String> occupiedSeats = ticketRepository.findBySchedule_ScheduleId(scheduleId)
                .stream()
                .map(ticket -> ticket.getSeat().getSeat_id())
                .collect(Collectors.toList()); // Sử dụng Set để tìm kiếm nhanh hơn

        // Map list chỗ ngồi của phòng sang list DTO SeatResponse
        List<SeatResponse> filteredSeats = seatList.stream().map(seat -> {
            // Chuyển đổi Seat thành SeatResponse
            SeatResponse seatDTO = seatMapper.toSeatResponse(seat);

            // Kiểm tra nếu ghế đã bị chiếm thì đánh dấu
            if (occupiedSeats.contains(seat.getSeat_id())) {
                seatDTO.setIsOccupied(1);
            } else {
                seatDTO.setIsOccupied(0); // Nếu chưa bị chiếm thì đánh dấu chưa chiếm
            }
            return seatDTO;
        }).collect(Collectors.toList());

        return filteredSeats; // Trả về danh sách SeatResponse
    }
}
