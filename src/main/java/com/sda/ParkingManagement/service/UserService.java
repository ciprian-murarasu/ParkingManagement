package com.sda.ParkingManagement.service;

import com.sda.ParkingManagement.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

