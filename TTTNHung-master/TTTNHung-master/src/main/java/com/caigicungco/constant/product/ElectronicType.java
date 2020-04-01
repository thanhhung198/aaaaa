package com.caigicungco.constant.product;

public enum  ElectronicType {

    MOBILE("mobile"),
    LAPTOP("laptop");
    private String value;

    ElectronicType(String value) {
        this.value = value;
    }

    public String Value() {
        return value;
    }
}
