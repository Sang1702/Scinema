package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.reponse.RoomResponse;
import com.demoProject.Scinema.mapper.RoomMapper;
import com.demoProject.Scinema.repository.RoomRepository;
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
public class RoomService implements IRoomService
{
    RoomRepository roomRepository;

    RoomMapper roomMapper;

    @Override
    public List<RoomResponse> getRooms(String movieId, String theaterId, String startDate, String startTime) {
        return roomRepository.getRoomByMovieIdAndTheaterIdAndSchedule(movieId, theaterId, startDate, startTime)
                .stream().map(roomMapper::toRoomResponse)
                .collect(Collectors.toList());
    }
}
