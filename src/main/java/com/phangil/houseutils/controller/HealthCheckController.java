package com.phangil.houseutils.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phangil.houseutils.constants.ActionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {
    private final ObjectMapper objectMapper;
    @Value("${test:}")
    private List<String> cloudianRegionCodes;

    @GetMapping("/api/ping")
    public String ping() throws JsonProcessingException {
        System.out.println("test:"+cloudianRegionCodes);
        cloudianRegionCodes.add("one");


        return "ok";

    }

    @Getter
    @AllArgsConstructor
    public class Taa {
        private String name;
        private int price;
        private LocalDate date;
    }

}


