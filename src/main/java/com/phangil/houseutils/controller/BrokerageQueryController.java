package com.phangil.houseutils.controller;

import com.phangil.houseutils.constants.ActionType;
import com.phangil.houseutils.policy.BrokeragePolicy;
import com.phangil.houseutils.policy.BrokeragePolicyFactory;
import com.phangil.houseutils.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BrokerageQueryController {
    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calBrokerage(@RequestParam ActionType actionType,
                             @RequestParam Long price) {
        //타입 정의 - 매매 / 임대차

        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);

    }

    @GetMapping("/api/cacl/{apartmentId}")
    public Long caclBrokerageByApartmentId(
            @PathVariable Long apartmentId,
            @RequestParam ActionType actionType
    ) {
    BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
    Long price = apartmentService.getPriceOrThrow(apartmentId);
    return policy.calculate(price);
    }

}
