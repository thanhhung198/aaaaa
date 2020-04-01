package com.caigicungco.DTO;

import lombok.Data;

@Data
public class ShopCart_ElectronicDTO {
    //    private ShopCartDTO shopCart;
    private Long productId;
    private ElectronicDTO electronic;
    private Integer quantity;
}
