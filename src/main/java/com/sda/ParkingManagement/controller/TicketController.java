package com.sda.ParkingManagement.controller;

import com.sda.ParkingManagement.DTO.TicketDto;
import com.sda.ParkingManagement.model.Ticket;
import com.sda.ParkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String create(Model model) {
        TicketDto ticketDto = ticketService.create();
        model.addAttribute("ticketCode", ticketDto.getCode());

        return "index";
    }

    @GetMapping()
    Ticket getByCode(String code) {
        return ticketService.getByCode(code);
    }
}
