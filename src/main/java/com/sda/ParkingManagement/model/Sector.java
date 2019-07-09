package com.sda.ParkingManagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "sectors")
public class Sector {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Sector name is missing")
    private String name;

    @OneToMany(mappedBy = "sector")
    private List<ParkingSpace> parkingSpaces;

    public Sector(@NotNull(message = "Sector name is missing") String name, List<ParkingSpace> parkingSpaces) {
        this.name = name;
        this.parkingSpaces = parkingSpaces;
    }

    public Sector() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }
}
