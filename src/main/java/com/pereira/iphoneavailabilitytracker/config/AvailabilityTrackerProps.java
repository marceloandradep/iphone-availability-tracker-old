package com.pereira.iphoneavailabilitytracker.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("availability-tracker")
public class AvailabilityTrackerProps {

    private int periodInMinutes;
    private String zipcode;
    private Notification notification;

    @Data
    public static class Notification {
        private boolean enabled;
    }

}
