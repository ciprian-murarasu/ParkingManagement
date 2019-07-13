package com.sda.ParkingManagement.repository;

import com.sda.ParkingManagement.model.Subscription;
import com.sda.ParkingManagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findAll();

    Subscription findByCode(String code);

    Subscription findByStartDate(Timestamp startDate);

    Subscription findByEndDate(Timestamp endDate);
}
