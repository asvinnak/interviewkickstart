package com.ash.ik.systemdesign.parkinglot.vehicle;

import com.ash.ik.systemdesign.parkinglot.ParkingTicket;
import com.ash.ik.systemdesign.parkinglot.enums.VehicleType;

public abstract class Vehicle {

    private ParkingTicket parkingTicket;
    private VehicleType vehicleType;
    private  String licenplateNum;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean assignTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
        return true;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicenplateNum() {
        return licenplateNum;
    }

    public void setLicenplateNum(String licenplateNum) {
        this.licenplateNum = licenplateNum;
    }
}
