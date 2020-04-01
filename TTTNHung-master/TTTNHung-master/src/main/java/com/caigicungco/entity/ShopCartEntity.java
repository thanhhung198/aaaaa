package com.caigicungco.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblshop_cart")
@Data
public class ShopCartEntity extends BaseEntity{

    @OneToMany(mappedBy = "shopCart",fetch = FetchType.LAZY)
    private List<ShopCart_ElectronicEntity> shopCart_electronics;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "provice_id")
    private Long proviceId;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "ward_id")
    private Long wardId;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "type_pay")
    private String typePay;
}
