package com.sda.ParkingManagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parking_spaces")
public class ParkingSpace {
    @Id
    private Long id;

    @NotNull(message = "Parking space status is missing")
    private boolean isFree;

    @NotNull(message = "Parking space number is missing")
    private Integer number;

    @ManyToOne()
    @JoinColumn(name = "sector_id")
    private Sector sector;

    public ParkingSpace(@NotNull(message = "Parking space number is missing") Integer number, Sector sector) {
        this.isFree = true;
        this.number = number;
        this.sector = sector;
    }

    public ParkingSpace() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
