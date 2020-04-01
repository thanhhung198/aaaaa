package com.caigicungco.constant.product;

public enum  ElectronicStatus {
    CON_HANG(0),
    HET_HANG(1),
    KHONG_KINH_DOANH(2),
    NGUNG_KINH_DOANH(3);


    private int value;
    ElectronicStatus(int value) {
        this.value = value;
    }

    public int Value() {
        return value;
    }
}
