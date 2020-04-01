package com.caigicungco.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopCartDTO {
    private List<ShopCart_ElectronicDTO> products = new ArrayList<>();

    private String firstname;

    private String lastname;

    private String address;

    private Long proviceId;

    private Long districtId;

    private Long wardId;

    private Long totalPrice;

    private String typePay;
}
