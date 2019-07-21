package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.model.Ticket;
import com.sda.ParkingManagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.Timestamp;

@Service
public class ExitService {
    private TicketRepository ticketRepository;

    @Autowired
    public ExitService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    private Ticket getByCode(String code) {
        return ticketRepository.findByCode(code);
    }

//    public void exit(String code) {
//        Ticket ticket = getByCode(code);
//        Timestamp currentDate = new Timestamp(new Date().getTime());
//        if (ticket.getExitDate() != null && (int) ((currentDate.getTime() - ticket.getExitDate().getTime()) / (1000 * 60)) <= 15) {
//            ticket.setExitDate(currentDate);
//            ticketRepository.save(ticket);
//        }
//    }
}
