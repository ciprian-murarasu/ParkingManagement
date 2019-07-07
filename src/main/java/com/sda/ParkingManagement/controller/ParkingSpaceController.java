package com.sda.ParkingManagement.controller;

import com.sda.ParkingManagement.model.ParkingSpace;
import com.sda.ParkingManagement.model.Sector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParkingSpaceController {

    private static List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();

//    static {
//        parkingSpaces.add(new ParkingSpace(12, new Sector("A", new ));
//    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", parkingSpaces);

        return "index";
    }

    @GetMapping(value = {"/parkingspaces"})
    public String viewPersonList(Model model) {

        model.addAttribute("persons", model);

        return "parkingspaces";
    }

}
