package com.pereira.iphoneavailabilitytracker.controllers;

import com.pereira.iphoneavailabilitytracker.domain.AvailableAt;
import com.pereira.iphoneavailabilitytracker.services.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    @GetMapping("/availability")
    @ResponseBody
    public List<AvailableAt> checkAvailability() {
        return availabilityService.checkAvailability();
    }

}
