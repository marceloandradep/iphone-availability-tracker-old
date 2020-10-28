package com.pereira.iphoneavailabilitytracker.integrations;

import com.pereira.iphoneavailabilitytracker.domain.Phone;
import com.pereira.iphoneavailabilitytracker.integrations.dto.PickupMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class AppleStoreClient {

    private final RestTemplate restTemplate;

    public PickupMessageDto pickupMessage(Phone phone, String location) {
        UriComponentsBuilder builder =
                UriComponentsBuilder
                        .fromHttpUrl("https://www.apple.com/us-hed/shop/retail/pickup-message")
                        .queryParam("pl", "true")
                        .queryParam("cppart", phone.getCarrier().getDescription())
                        .queryParam("location", location)
                        .queryParam("parts.0", phone.getReference());

        ResponseEntity<PickupMessageDto> entity =
                restTemplate.getForEntity(builder.toUriString(), PickupMessageDto.class);

        return entity.getBody();
    }

}
