package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    private TicketRepository ticketRepository;


    public BillService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }


}
