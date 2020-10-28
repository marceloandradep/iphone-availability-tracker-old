package com.pereira.iphoneavailabilitytracker.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("email-notification")
public class EmailNotificationProps {

    private String to;

}
