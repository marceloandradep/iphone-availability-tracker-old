package com.pereira.iphoneavailabilitytracker.constants;

import lombok.Getter;

public enum PhoneCapacity {

    GB_128("126GB"),
    GB_256("256GB"),
    GB_512("512GB");

    @Getter
    private final String description;

    PhoneCapacity(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
