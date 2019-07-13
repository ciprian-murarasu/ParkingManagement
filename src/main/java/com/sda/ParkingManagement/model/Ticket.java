package com.sda.ParkingManagement.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    Long id;

    private String code;

    @Range(min = 0, message = "Invalid payed amount")
    private
    Integer payedAmount;

    @NotNull
    private Timestamp enterDate;

    private Timestamp exitDate;

    private Timestamp payDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Integer payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Timestamp getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Timestamp enterDate) {
        this.enterDate = enterDate;
    }

    public Timestamp getExitDate() {
        return exitDate;
    }

    public void setExitDate(Timestamp exitDate) {
        this.exitDate = exitDate;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }
}
