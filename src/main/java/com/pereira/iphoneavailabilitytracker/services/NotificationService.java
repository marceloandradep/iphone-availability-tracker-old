package com.pereira.iphoneavailabilitytracker.services;

import com.pereira.iphoneavailabilitytracker.domain.*;
import com.pereira.iphoneavailabilitytracker.services.notification.NotificationMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    /*
    In memory tracking of phone availability already notified.
     */
    private static final Map<String, Notification> notifications = new HashMap<>();

    private final NotificationMethod notificationMethod;

    public void sendNotification(List<AvailableAt> availableList) {
        if (availableList != null && !availableList.isEmpty()) {
            StringBuilder message = new StringBuilder();

            availableList.forEach(availableAt -> {
                if (shouldSend(availableAt)) {
                    appendAvailability(availableAt, message);
                    addToIgnoreList(availableAt.getPhone(), availableAt.getStore());
                }
            });

            if (StringUtils.isEmpty(message.toString())) {
                log.info("Nothing to send.");
            } else {
                notificationMethod.send(message.toString());
            }
        }
    }

    private void addToIgnoreList(Phone phone, Store store) {
        notifications.put(getKey(phone, store), new Notification(phone, LocalDate.now()));
    }

    private String getKey(Phone phone, Store store) {
        return phone.getReference() + phone.getCarrier() + store.getName();
    }

    public boolean shouldSend(AvailableAt available) {
        Phone phone = available.getPhone();
        Store store = available.getStore();

        Notification notification = notifications.get(getKey(phone, store));

        if (notification == null) {
            return true;
        } else {
            return !LocalDate.now().equals(notification.getDate());
        }
    }

    public void appendAvailability(AvailableAt available, StringBuilder message) {
        Phone phone = available.getPhone();
        Store store = available.getStore();

        message
                .append(phone.getModel()).append(" ").append(phone.getCarrier()).append(" - ")
                .append(phone.getColor()).append(" - ")
                .append(phone.getCapacity())
                .append(" available at ")
                .append(store.getName()).append(" - ")
                .append(store.getCity()).append(" - ")
                .append(store.getState())
                .append("\n");
    }

}
