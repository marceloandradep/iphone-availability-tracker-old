package com.pereira.iphoneavailabilitytracker.constants;

import lombok.Getter;

public enum PhoneModel {

    IPHONE_12_PRO("iPhone 12 Pro"),
    IPHONE_12_PRO_MAX("iPhone 12 Pro Max");

    @Getter
    private final String description;

    PhoneModel(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
