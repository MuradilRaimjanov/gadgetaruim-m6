package com.peaksoft.gadgetaruimm6.model.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public enum Review {
    DELIVERY_VARIETIES("DELIVERY_VARIETIES"),
    PAYMENT("PAYMENT"),
    ORDER_REVIEW("ORDER_REVIEW");

    private String stringType;

    Review(String stringType) {
        this.stringType = stringType;
    }
}