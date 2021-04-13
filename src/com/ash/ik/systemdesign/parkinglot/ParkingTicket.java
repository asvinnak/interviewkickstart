package com.ash.ik.systemdesign.parkinglot;

import java.time.LocalDateTime;

import com.ash.ik.systemdesign.parkinglot.enums.ParkingTicketStatus;

public class ParkingTicket {

    private String ticketNum;

    private LocalDateTime issuedAt;

    private LocalDateTime paidAt;

    private double payedAmount;

    private ParkingTicketStatus status;

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public double getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(double payedAmount) {
        this.payedAmount = payedAmount;
    }

    public ParkingTicketStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }
}
