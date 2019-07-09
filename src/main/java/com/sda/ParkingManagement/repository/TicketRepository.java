package com.sda.ParkingManagement.repository;

import com.sda.ParkingManagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAll();

    Ticket findByCode(String code);

    Ticket findByCodeAndPayDate(String code, Timestamp payDate);
}
