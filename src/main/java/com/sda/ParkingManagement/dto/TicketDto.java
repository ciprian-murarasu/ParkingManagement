package com.sda.ParkingManagement.dto;

public class TicketDto {
    private String code;
    private Integer price;
    private Boolean calculated;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean isCalculated() {
        return calculated != null;
    }

    public void setCalculated(Boolean calculated) {
        this.calculated = calculated;
    }
}


