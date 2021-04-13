package com.ash.ik.systemdesign.parkinglot.parkingspot;

import com.ash.ik.systemdesign.parkinglot.enums.ParkingSpotType;
import com.ash.ik.systemdesign.parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {

    private String number;
    private ParkingSpotType spotType;
    private Vehicle vehicle;
    private boolean free;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public ParkingSpot(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isFree() {
        return free;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
        return true;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        free = true;
        return true;
    }


}
