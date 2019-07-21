package com.sda.ParkingManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ParkingManagementApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ParkingManagementApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ParkingManagementApplication.class, args);
    }
}
