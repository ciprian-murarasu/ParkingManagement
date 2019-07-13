package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.dto.SubscriptionDto;
import com.sda.ParkingManagement.model.Subscription;
import com.sda.ParkingManagement.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public SubscriptionDto create() {
        Subscription subscription = new Subscription();
        subscription.setCode(generateCode());
        subscription.setStartDate(new Timestamp(new Date().getTime()));
        subscriptionRepository.save(subscription);

        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setCode(subscription.getCode());
        return subscriptionDto;
    }

    private String generateCode() {
        return "A" + (long) (Math.floor(Math.random() * 900_000_000L) + 100_000_000);
    }

    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    public Subscription getByCode(String code) {
        return subscriptionRepository.findByCode(code);
    }

    public Subscription getByStartDate(Timestamp startDate) {
        return subscriptionRepository.findByStartDate(startDate);
    }

    public Subscription getByEndDate(Timestamp endDate) {
        return subscriptionRepository.findByStartDate(endDate);
    }

    public Subscription update(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }
}
