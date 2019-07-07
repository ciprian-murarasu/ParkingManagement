package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.model.ParkingSpace;
import com.sda.ParkingManagement.repository.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    public ParkingSpace create(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    public List<ParkingSpace> getAll(){
        return parkingSpaceRepository.findAll();
    }

    public ParkingSpace getBySectorAndNumber(String sectorName, Integer number){
        return parkingSpaceRepository.findBySectorAndNumber(sectorName, number);
    }

    public ParkingSpace update(ParkingSpace parkingSpace){
        return parkingSpaceRepository.save(parkingSpace);
    }
}
