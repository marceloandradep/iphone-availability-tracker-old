package com.pereira.iphoneavailabilitytracker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Store {

    @JsonProperty("storeName")
    private String name;
    private String state;
    private String city;
    private Map<String, Availability> partsAvailability;
}
