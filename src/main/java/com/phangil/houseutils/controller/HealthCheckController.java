package com.phangil.houseutils.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phangil.houseutils.constants.ActionType;
import com.phangil.houseutils.constants.MyAnnotation;

import com.phangil.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {
    private final ObjectMapper objectMapper;
    private final ApartmentService apartmentService;
    @Value("${test:}")
    private List<String> cloudianRegionCodes;

    @GetMapping("/api/ping")
    public String ping() throws JsonProcessingException {
        System.out.println("test:"+cloudianRegionCodes);
        cloudianRegionCodes.add("one");
        return "ok";
    }

    @MyAnnotation(value = "my new Annotation")
    @PostMapping("/test")
    public void test(@RequestBody @Valid Goods goods) {
        System.out.println("들어옴 : " + goods);
    }


    @PostMapping("/test2")
    public void test2() throws Exception {
        apartmentService.roll();
    }

    @GetMapping("/good")
    public RedirectView tesss() {
        return new RedirectView("https://dev-auth.ncloud.com/oauth/authorize?client_id=sso&response_type=code&redirect_uri=https://dev-sso.ncloud.com/callback&scope=write&state=d8f51ce1-8230-4453-a448-2a92a57ce37a");

    }

    @GetMapping("/login")
    public RedirectView login() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res =restTemplate.getForEntity("https://beta-sso.ncloud.com/tenants/f4253276-8e7f-4443-b992-8076b6a51b10/oauth2/authorize?client_id=8f07955c-5d22-45c7-9e17-3c7b789e33bd&scope=profile&response_type=code&redirect_uri=http://localhost:1234/code&state=null", String.class);
        System.out.println(res);
        String location = res.getHeaders().get("Location").get(0);
        System.out.println("## Location :" + res.getHeaders().get("Location"));
        return new RedirectView("https://dev-auth.ncloud.com/oauth/authorize?client_id=sso&response_type=code&redirect_uri=https://dev-sso.ncloud.com/callback&scope=write&state=d8f51ce1-8230-4453-a448-2a92a57ce37a ");
//        return new RedirectView("https://beta-sso.ncloud.com/tenants/f4253276-8e7f-4443-b992-8076b6a51b10/oauth2/authorize?client_id=8f07955c-5d22-45c7-9e17-3c7b789e33bd&scope=profile&response_type=code&redirect_uri=http://localhost:1234/code&state=null");
    }

    @GetMapping("/code")
    public void getCode(String code) {
        System.out.println("코드가 들어옴");
        System.out.println(code);
    }


    @Getter
    @AllArgsConstructor
    public class Taa {
        private String name;
        private int price;
        private LocalDate date;
    }

}


