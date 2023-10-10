package com.peaksoft.gadgetaruimm6.model.enums;

public enum SortBy {

    BY_SALE("Sale50"),
    BY_SALE_UP("SaleUpper50"),
    BY_ASC("ASC"),
    BY_DESC("DESC"),
    BY_NEW("ByNew"),

    BY_REC("ByRec");

    private String name;

    SortBy(String name) {
        this.name = name;
    }


}
