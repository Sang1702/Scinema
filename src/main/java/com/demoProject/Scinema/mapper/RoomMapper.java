package com.demoProject.Scinema.mapper;

import com.demoProject.Scinema.dto.reponse.RoomResponse;
import com.demoProject.Scinema.dto.request.RoomRequest;
import com.demoProject.Scinema.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper
{
    Room toRoom(RoomRequest request);
    RoomResponse toRoomResponse(Room room);
}
