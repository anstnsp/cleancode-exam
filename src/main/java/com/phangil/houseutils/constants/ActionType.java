package com.phangil.houseutils.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ActionType {
    PURCHASE("매매"),
    RENT("임대차");

    private final String description;

}
