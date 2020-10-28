package com.pereira.iphoneavailabilitytracker.integrations.dto;

import com.pereira.iphoneavailabilitytracker.domain.Store;
import lombok.Data;

import java.util.List;

@Data
public class PickupMessageDto {

    private Head head;
    private Body body;

    @Data
    public static class Head {
        private String status;
    }

    @Data
    public static class Body {
        private List<Store> stores;
    }

    public boolean isSuccess() {
        return this.getHead().getStatus().equals("200");
    }

}
