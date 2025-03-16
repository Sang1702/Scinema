package com.demoProject.Scinema.dto.reponse;

import lombok.Data;

@Data
public class SeatResponse
{
    private String id;
    private String name;
    private int isOccupied;
}
