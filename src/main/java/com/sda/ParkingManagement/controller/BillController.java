package com.sda.ParkingManagement.controller;

import com.sda.ParkingManagement.dto.TicketDto;
import com.sda.ParkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/payBill")
public class BillController {

    private TicketService ticketService;

    @Autowired
    public BillController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String payBill(TicketDto ticketDto, Model model){
        String billCode = ticketDto.getCode();
        if(StringUtils.isEmpty(billCode)){
            model.addAttribute("billMessage","Please enter a Ticket code");
        }
        else {
            
        }

        model.addAttribute("calculated", true);
        return "index";
    }
    
}
