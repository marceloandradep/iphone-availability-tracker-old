package com.pereira.iphoneavailabilitytracker.domain;

import com.pereira.iphoneavailabilitytracker.constants.PhoneCapacity;
import com.pereira.iphoneavailabilitytracker.constants.PhoneCarrier;
import com.pereira.iphoneavailabilitytracker.constants.PhoneColor;
import com.pereira.iphoneavailabilitytracker.constants.PhoneModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Phone {

    private final String reference;
    private final PhoneModel model;
    private final PhoneCapacity capacity;
    private final PhoneColor color;
    private final PhoneCarrier carrier;

}
