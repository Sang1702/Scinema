package com.demoProject.Scinema.service;

import com.demoProject.Scinema.dto.request.BookingRequestDTO;

public interface IBillService
{
    void createBill(BookingRequestDTO bookingRequestDTO) throws RuntimeException;
}
