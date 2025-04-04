package com.demoProject.Scinema.repository;

import com.demoProject.Scinema.dto.request.BookingRequestDTO;
import com.demoProject.Scinema.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, String>
{
}
