package com.sda.ParkingManagement.repository;

import com.sda.ParkingManagement.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findAll();

    ParkingSpace findBySectorAndNumber(String sectorName, Integer number);
}
