package com.caigicungco.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblgoods_issue")
public class GoodsIssueEntity extends BaseEntity{

    @OneToMany(mappedBy = "goodsIssue")
    private List<GoodsIssue_ElectronicEntity> goodsIssue_electronicEntities;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;


    public List<GoodsIssue_ElectronicEntity> getGoodsIssue_electronicEntities() {
        return goodsIssue_electronicEntities;
    }

    public void setGoodsIssue_electronicEntities(List<GoodsIssue_ElectronicEntity> goodsIssue_electronicEntities) {
        this.goodsIssue_electronicEntities = goodsIssue_electronicEntities;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
