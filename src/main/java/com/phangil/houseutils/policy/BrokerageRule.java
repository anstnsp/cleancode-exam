package com.phangil.houseutils.policy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 가격이 특정 범위일 때 상한효율과 상한금액 가지는 클래스
 */
@RequiredArgsConstructor
@Getter
public class BrokerageRule {
    private final Long lessThan;
    private final Double brokeragePercent; //상한효율 (중개수수료퍼센트)
    private final Long limitAmount; //한도액 (상한금액)

    public BrokerageRule(Long lessThan, Double brokeragePercent) {
        this(lessThan, brokeragePercent, Long.MAX_VALUE);
    }

    public Long calcMaxBrokerage(Long price) {
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }

}
