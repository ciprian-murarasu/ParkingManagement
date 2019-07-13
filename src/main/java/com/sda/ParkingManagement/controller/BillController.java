package com.sda.ParkingManagement.controller;

import com.sda.ParkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/payBill")
public class BillController {

    private TicketService ticketService;

    @Autowired
    public BillController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    
}
