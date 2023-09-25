package com.peaksoft.gadgetaruimm6.model.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Memory {
    EIGHT_GB("8ГБ"),
    SIXTEEN_GB("16ГБ"),
    THIRTY_GB("32ГБ"),
    SIXTY_GB("64ГБ"),
    HUNDRED_TWENTY_EIGHT_GB("128ГБ"),
    TWO_HUNDRED_FIFTY_SIX_GB("256ГБ"),
    FIVE_HUNDRED_TWELVE_GB("512ГБ");
    private String name;

    Memory(String name) {
        this.name = name;
    }
}
