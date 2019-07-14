package com.sda.ParkingManagement.controller;

import com.sda.ParkingManagement.dto.AccessDto;
import com.sda.ParkingManagement.dto.TicketDto;
import com.sda.ParkingManagement.model.Subscription;
import com.sda.ParkingManagement.model.Ticket;
import com.sda.ParkingManagement.service.SubscriptionService;
import com.sda.ParkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping(value = "/access")
public class AccessController {
    private TicketService ticketService;
    private SubscriptionService subscriptionService;

    @Autowired
    public AccessController(TicketService ticketService, SubscriptionService subscriptionService) {
        this.ticketService = ticketService;
        this.subscriptionService = subscriptionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String accesParking(AccessDto accessDto, Model model) {
        String code = accessDto.getCode();
        if (StringUtils.isEmpty(code)) {
            TicketDto ticketDto = ticketService.create();
//            model.addAttribute("generatedCode", true);
            model.addAttribute("ticketCode", ticketDto.getCode());
            model.addAttribute("accessMessage", "Access granted. Welcome!");
        } else {
            Subscription subscription = subscriptionService.getByCode(code);
            if (subscription == null) {
                model.addAttribute("accessMessage", "Invalid subscription. Access denied");
            } else {
                Timestamp currentDate = new Timestamp(new Date().getTime());
                if (subscription.getEndDate().compareTo(currentDate) < 0) {
                    model.addAttribute("accessMessage", "Subscription expired. Access denied");
                } else {
                    model.addAttribute("accessMessage", "Access granted. Welcome!");
                }
            }
        }
        return "index";
    }

}
