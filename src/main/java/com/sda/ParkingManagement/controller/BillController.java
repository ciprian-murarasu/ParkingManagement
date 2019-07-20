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
@RequestMapping(value = "/tickets")
public class BillController {
    private TicketService ticketService;

    @Autowired
    public BillController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/pay",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String calculatePrice(TicketDto ticketDto, Model model) {
        String code = ticketDto.getCode();
        if (StringUtils.isEmpty(code)) {
            model.addAttribute("errorMessage", "Please enter a ticket code");
            return "index";
        }

        try {
            if(ticketDto.isCalculated()) {
                ticketService.payTicket(code);
                model.addAttribute("payed", true);
                model.addAttribute("payMessage", "Ticket payed. Now you can exit");
            } else {
                Integer price = ticketService.calculatePrice(code);
                model.addAttribute("calculatedResponse", true);
                model.addAttribute("price", price);
                model.addAttribute("code", code);
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Invalid code. Try again");
        }

        return "index";
    }

//    @PostMapping(value = "/pay", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String payTicket(TicketDto ticketDto, Model model) {
//        String code = ticketDto.getCode();
//
//        return "index";
//    }

}
