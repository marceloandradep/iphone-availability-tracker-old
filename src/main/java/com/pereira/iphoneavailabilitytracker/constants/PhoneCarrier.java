package com.pereira.iphoneavailabilitytracker.constants;

import lombok.Getter;

public enum PhoneCarrier {

    UNLOCKED_US("UNLOCKED/US"),
    TMOBILE_US("TMOBILE/US");

    @Getter
    private final String description;

    PhoneCarrier(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
