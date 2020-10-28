package com.pereira.iphoneavailabilitytracker.services.notification;

import com.pereira.iphoneavailabilitytracker.config.EmailNotificationProps;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailNotification implements NotificationMethod {

    private final JavaMailSender javaMailSender;
    private final EmailNotificationProps emailNotificationProps;

    @Override
    public void send(String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("noreply@pereira.com");
        simpleMailMessage.setTo(emailNotificationProps.getTo());
        simpleMailMessage.setSubject("iPhone Availability");
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);
    }
}
