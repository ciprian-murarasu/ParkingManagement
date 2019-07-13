package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.dto.TicketDto;
import com.sda.ParkingManagement.model.Ticket;
import com.sda.ParkingManagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketDto create() {
        Ticket ticket = new Ticket();
        ticket.setCode(generateCode());
        ticket.setEnterDate(new Timestamp(new Date().getTime()));
        ticketRepository.save(ticket);

        TicketDto ticketDto = new TicketDto();
        ticketDto.setCode(ticket.getCode());
        return ticketDto;
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getByCode(String code) {
        return ticketRepository.findByCode(code);
    }

    public Ticket getByCodeAndPayDate(String code, Timestamp payDate) {
        return ticketRepository.findByCodeAndPayDate(code, payDate);
    }

    public Ticket update(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    private String generateCode() {
        return "T" + (long) (Math.floor(Math.random() * 900_000_000L) + 100_000_000);
    }
}
