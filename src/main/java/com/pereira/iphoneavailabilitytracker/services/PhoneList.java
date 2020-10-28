package com.pereira.iphoneavailabilitytracker.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pereira.iphoneavailabilitytracker.domain.Phone;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneList {

    private final ObjectMapper objectMapper;

    @Value("classpath:phone-list.json")
    private Resource phoneList;

    @Getter
    private List<Phone> models;

    @PostConstruct
    public void init() throws IOException {
        models = objectMapper.readValue(phoneList.getInputStream(), new TypeReference<List<Phone>>(){});
    }

}
