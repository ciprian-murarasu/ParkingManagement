package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.model.Ticket;
import com.sda.ParkingManagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }

    public Ticket getByCode(String code){
        return ticketRepository.findByCode(code);
    }
    public Ticket getByCodeAndPayDate(String code, Timestamp payDate){
        return ticketRepository.findByCodeAndPayDate(code, payDate);
    }

    public Ticket update(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
