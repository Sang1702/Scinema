package com.demoProject.Scinema.dto.request;

import lombok.Data;

@Data
public class SeatRequest
{
    private String id;
    private String name;
    private int isOccupied;
}
