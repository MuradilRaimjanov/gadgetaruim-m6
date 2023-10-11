package com.peaksoft.gadgetaruimm6.model.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum MemoryRam {

    SIX_GB("6ГБ"),
    EIGHT_GB("8ГБ"),
    SIXTEEN_GB("16ГБ"),
    THIRTY_GB("32ГБ");

    private String name;

    MemoryRam(String name) {
        this.name = name;
    }
}
