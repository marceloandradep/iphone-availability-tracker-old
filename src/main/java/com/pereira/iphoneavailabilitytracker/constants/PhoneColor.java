package com.pereira.iphoneavailabilitytracker.constants;

import lombok.Getter;

public enum PhoneColor {

    GRAPHITE("Graphite"),
    SILVER("Silver"),
    GOLD("Gold"),
    PACIFIC_BLUE("Pacific Blue");

    @Getter
    private final String description;

    PhoneColor(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
