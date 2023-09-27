package com.peaksoft.gadgetaruimm6.model.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Shipping {
    PICK_UP_FROM_THE_STORE("Самовывоз из магазина"),
    DELIVERY_BY_COURIER("Доставка курьером");

    String name;

    Shipping(String name) {
        this.name = name;
    }
}
