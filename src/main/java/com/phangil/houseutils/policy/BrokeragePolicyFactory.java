package com.phangil.houseutils.policy;

import com.phangil.houseutils.constants.ActionType;

public class BrokeragePolicyFactory {

    private final static RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();
    private final static PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return rentBrokeragePolicy;
            case PURCHASE:
                return purchaseBrokeragePolicy;
            default:
                throw new IllegalArgumentException("해당 actionType에 대한 정책이 존재하지 않습니다.");
        }
    }

}
