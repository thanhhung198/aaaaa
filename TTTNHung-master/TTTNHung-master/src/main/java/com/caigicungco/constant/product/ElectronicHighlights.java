package com.caigicungco.constant.product;

public enum  ElectronicHighlights {
    HOT("hot"),
    TOP("top"),
    NEW("new");


    private String value;
    ElectronicHighlights(String value) {
        this.value = value;
    }

    public String Value() {
        return value;
    }
}
