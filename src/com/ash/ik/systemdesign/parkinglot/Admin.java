package com.ash.ik.systemdesign.parkinglot;

import com.ash.ik.systemdesign.parkinglot.parkingspot.ParkingSpot;

public class Admin extends Account {

    public boolean addParkingFloor(ParkingFloor parkingFloor) {
        return false;
    }

    public boolean addParkingSpot(String floorName, ParkingSpot parkingSpot) {
        return false;
    }

    public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard parkingDisplayBoard) {
        return false;
    }

    // public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel customerInfoPanel) {
    //     return false;
    // }
    //
    // public boolean addEntrancePanel(EntrancePanel entrancePanel) {
    //     return false;
    // }
    //
    // public boolean addExitPanel(ExitPanel exitPanel) {
    //     return false;
    // }
}


