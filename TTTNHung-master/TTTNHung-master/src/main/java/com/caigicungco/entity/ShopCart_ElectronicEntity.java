package com.caigicungco.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblshop_cart_electronic")
@Data
public class ShopCart_ElectronicEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "shop_cart_id")
    private ShopCartEntity shopCart;

    @ManyToOne
    @JoinColumn(name = "electronic_id")
    private ElectronicEntity electronic;

    @Column(name = "quantity")
    private Integer quantity;

}
