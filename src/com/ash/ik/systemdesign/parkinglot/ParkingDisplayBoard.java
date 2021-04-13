package com.ash.ik.systemdesign.parkinglot;

import com.ash.ik.systemdesign.parkinglot.parkingspot.LargeSpot;
import com.ash.ik.systemdesign.parkinglot.parkingspot.MediumSpot;
import com.ash.ik.systemdesign.parkinglot.parkingspot.SmallSpot;

public class ParkingDisplayBoard {

    private String id;
    private LargeSpot largeSpot;
    private MediumSpot mediumSpot;
    private SmallSpot smallSpot;


    public void showEmptySpotNumber() {
        String message= "";

        if(largeSpot.isFree()) {
            message +="Free large spots : "+ largeSpot.getNumber();
        } else {
            message += "Large spot is Full";
        }
        message += System.lineSeparator();

        if(mediumSpot.isFree()) {
            message +="Free mediu  spots : "+ mediumSpot.getNumber();
        } else {
            message += "Large spot is Full";
        }
        message += System.lineSeparator();
        if(smallSpot.isFree()) {
            message +="Free small spots : "+ smallSpot.getNumber();
        } else {
            message += "Large spot is Full";
        }

        //show(message);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LargeSpot getLargeSpot() {
        return largeSpot;
    }

    public void setLargeSpot(LargeSpot largeSpot) {
        this.largeSpot = largeSpot;
    }

    public MediumSpot getMediumSpot() {
        return mediumSpot;
    }

    public void setMediumSpot(MediumSpot mediumSpot) {
        this.mediumSpot = mediumSpot;
    }

    public SmallSpot getSmallSpot() {
        return smallSpot;
    }

    public void setSmallSpot(SmallSpot smallSpot) {
        this.smallSpot = smallSpot;
    }
}
