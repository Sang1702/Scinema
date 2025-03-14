package com.demoProject.Scinema.controller;

import com.demoProject.Scinema.dto.reponse.RoomResponse;
import com.demoProject.Scinema.dto.request.ApiResponse;
import com.demoProject.Scinema.service.RoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoomController
{
    RoomService roomService;

    @GetMapping
    public ApiResponse<List<RoomResponse>> getRooms(@RequestParam String movieId, @RequestParam String theaterId,
                                                    @RequestParam String startDate, @RequestParam String startTime)
    {
        return ApiResponse.<List<RoomResponse>>builder()
                .result(roomService.getRooms(movieId, theaterId, startDate, startTime))
                .build();
    }
}
