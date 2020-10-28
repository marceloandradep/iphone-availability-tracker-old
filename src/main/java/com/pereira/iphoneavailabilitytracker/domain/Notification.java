package com.pereira.iphoneavailabilitytracker.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class Notification {

    private final Phone phone;
    private final LocalDate date;

}
