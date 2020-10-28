package com.pereira.iphoneavailabilitytracker.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AvailableAt {

    private final Phone phone;
    private final Store store;

}
