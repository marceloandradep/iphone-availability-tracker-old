package com.pereira.iphoneavailabilitytracker.domain;

import lombok.Data;

@Data
public class Availability {

    private String pickupDisplay;

    public boolean isAvailable() {
        return this.getPickupDisplay().equals("available");
    }

}
