package com.ash.ik.systemdesign.parkinglot;

import java.util.Map;

import com.ash.ik.systemdesign.parkinglot.enums.ParkingSpotType;
import com.ash.ik.systemdesign.parkinglot.parkingspot.LargeSpot;
import com.ash.ik.systemdesign.parkinglot.parkingspot.MediumSpot;
import com.ash.ik.systemdesign.parkinglot.parkingspot.ParkingSpot;
import com.ash.ik.systemdesign.parkinglot.parkingspot.SmallSpot;
import com.ash.ik.systemdesign.parkinglot.vehicle.Vehicle;

public class ParkingFloor {

    private String name;
    private Map<String, LargeSpot> largeSpot;
    private Map<String, MediumSpot> mediumSpot;
    private Map<String, SmallSpot> smallSpot;
    private ParkingDisplayBoard parkingDisplayBoard;
    private boolean full;



    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        switch(parkingSpot.getSpotType()) {
            case LARGE:
                largeSpot.put(parkingSpot.getNumber(), (LargeSpot) parkingSpot);
                break;
            case MEDIUM:
                mediumSpot.put(parkingSpot.getNumber(), (MediumSpot) parkingSpot);
                break;
            case SMALL:
                smallSpot.put(parkingSpot.getNumber(), (SmallSpot) parkingSpot);
                break;
            default:
                System.out.println("Wrng ");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
        switch (spot.getSpotType()) {
            case MEDIUM:
                updateDisplayBoardForMedium(spot);
                break;
            case LARGE:
                updateDisplayBoardForLarge(spot);
                break;
            case SMALL:
                updateDisplayBoardForSmall(spot);
                break;

            default:
                //print("Wrong parking spot type!");
        }
    }



    private void updateDisplayBoardForLarge(ParkingSpot parkingSpot) {
        if(parkingDisplayBoard.getLargeSpot().getNumber() == parkingSpot.getNumber()) {
            for(String key : largeSpot.keySet()) {
                if(largeSpot.get(key).isFree()) {
                    this.parkingDisplayBoard.setLargeSpot(largeSpot.get(key));
                }
            }
            this.parkingDisplayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForMedium(ParkingSpot parkingSpot) {
        if(parkingDisplayBoard.getLargeSpot().getNumber() == parkingSpot.getNumber()) {
            for(String key : mediumSpot.keySet()) {
                if(mediumSpot.get(key).isFree()) {
                    this.parkingDisplayBoard.setMediumSpot(mediumSpot.get(key));
                }
            }
            this.parkingDisplayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForSmall(ParkingSpot parkingSpot) {
        if(parkingDisplayBoard.getLargeSpot().getNumber() == parkingSpot.getNumber()) {
            for(String key : smallSpot.keySet()) {
                if(smallSpot.get(key).isFree()) {
                    this.parkingDisplayBoard.setSmallSpot(smallSpot.get(key));
                }
            }
            this.parkingDisplayBoard.showEmptySpotNumber();
        }
    }

    public void freeSpot(ParkingSpot spot) {
        spot.removeVehicle(spot.getVehicle());

        // switch (spot.getSpotType()) {
        //     case ParkingSpotType.SMALL:
        //         //freeCompactSpotCount++;
        //         break;
        //     case ParkingSpotType.LARGE:
        //         //freeLargeSpotCount++;
        //         break;
        //     case ParkingSpotType.MEDIUM:
        //         //freeMotorbikeSpotCount++;
        //         break;
        //
        // }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, LargeSpot> getLargeSpot() {
        return largeSpot;
    }

    public void setLargeSpot(Map<String, LargeSpot> largeSpot) {
        this.largeSpot = largeSpot;
    }

    public Map<String, MediumSpot> getMediumSpot() {
        return mediumSpot;
    }

    public void setMediumSpot(Map<String, MediumSpot> mediumSpot) {
        this.mediumSpot = mediumSpot;
    }

    public Map<String, SmallSpot> getSmallSpot() {
        return smallSpot;
    }

    public void setSmallSpot(Map<String, SmallSpot> smallSpot) {
        this.smallSpot = smallSpot;
    }

    public ParkingDisplayBoard getParkingDisplayBoard() {
        return parkingDisplayBoard;
    }

    public void setParkingDisplayBoard(ParkingDisplayBoard parkingDisplayBoard) {
        this.parkingDisplayBoard = parkingDisplayBoard;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
