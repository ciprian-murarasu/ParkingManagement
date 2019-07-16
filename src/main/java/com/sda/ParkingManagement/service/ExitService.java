package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.repository.SubscriptionRepository;
import com.sda.ParkingManagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExitService {
    private TicketRepository ticketRepository;
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public ExitService(TicketRepository ticketRepository, SubscriptionRepository subscriptionRepository){
        this.ticketRepository = ticketRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public void exit(){

    }
}
