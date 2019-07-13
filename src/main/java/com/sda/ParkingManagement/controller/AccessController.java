package com.sda.ParkingManagement.controller;

import com.sda.ParkingManagement.DTO.AccessDto;
import com.sda.ParkingManagement.DTO.TicketDto;
import com.sda.ParkingManagement.model.Ticket;
import com.sda.ParkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/access")
public class AccessController {
    private TicketService ticketService;

    @Autowired
    public AccessController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    @PostMapping()
//    public String create(Model model) {
//        TicketDto ticketDto = ticketService.create();
//        model.addAttribute("ticketCode", ticketDto.getCode());
//        return "index";
//    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String accesParking(AccessDto accessDto, Model model) {
        String code = accessDto.getCode();
        if (StringUtils.isEmpty(code)) {
            TicketDto ticketDto = ticketService.create();
            model.addAttribute("ticketCode", ticketDto.getCode());
        } else {
            // abonament
//            if(Objects.nonNull(subscriptionService.getByCode(code))){
            // subscription found
//            }
            model.addAttribute("ticketCode", "");
        }
        return "index";
    }

    @GetMapping()
    Ticket getByCode(String code) {
        return ticketService.getByCode(code);
    }
}
