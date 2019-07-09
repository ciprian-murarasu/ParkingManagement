package com.sda.ParkingManagement.controller;

import com.sda.ParkingManagement.model.Ticket;
import com.sda.ParkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tickets")
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping()
    Ticket create() {
        Ticket ticket = new Ticket();
        ticket.setCode(generateCode());
        return ticketService.create(ticket);
    }

    private String generateCode() {
        return "T" + (long) (Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000);
    }

    @GetMapping()
    Ticket getByCode(String code) {
        return ticketService.getByCode(code);
    }
}
