package com.pereira.iphoneavailabilitytracker.services;

import com.pereira.iphoneavailabilitytracker.config.AvailabilityTrackerProps;
import com.pereira.iphoneavailabilitytracker.domain.Availability;
import com.pereira.iphoneavailabilitytracker.domain.AvailableAt;
import com.pereira.iphoneavailabilitytracker.domain.Phone;
import com.pereira.iphoneavailabilitytracker.domain.Store;
import com.pereira.iphoneavailabilitytracker.integrations.AppleStoreClient;
import com.pereira.iphoneavailabilitytracker.integrations.dto.PickupMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class AvailabilityService {

    private final AppleStoreClient appleStoreClient;
    private final AvailabilityTrackerProps availabilityTrackerProps;
    private final NotificationService notificationService;
    private final PhoneList phoneList;

    @Scheduled(fixedRate = 300000) // 5 minutes
    public List<AvailableAt> checkAvailability() {
        List<AvailableAt> availableList = Collections.synchronizedList(new ArrayList<>());

        phoneList.getModels().parallelStream().forEach(phone -> {
            fetch(phone, availableList);
        });

        log.info("Phones available: [{}]", availableList);

        if (availabilityTrackerProps.getNotification().isEnabled()) {
            notificationService.sendNotification(availableList);
        }

        return availableList;
    }

    private void fetch(Phone phone, List<AvailableAt> availableList) {
        PickupMessageDto pickupMessageDto = appleStoreClient.pickupMessage(phone, availabilityTrackerProps.getZipcode());

        if (pickupMessageDto.isSuccess()) {
            List<Store> stores = pickupMessageDto.getBody().getStores();

            stores.forEach(store -> {
                Map<String, Availability> partsAvailability = store.getPartsAvailability();
                partsAvailability
                        .values().stream()
                        .filter(Availability::isAvailable)
                        .map(availability -> new AvailableAt(phone, store))
                        .forEach(availableList::add);
            });
        } else {
            log.error("Could not pick results. [{}]", pickupMessageDto);
        }
    }

}
