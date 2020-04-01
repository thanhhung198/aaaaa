package com.caigicungco.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblcustomer",uniqueConstraints = @UniqueConstraint(columnNames = "phone"))
public class CustomerEntity extends BaseEntity{

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "total_money")
    private int totalMoney;

    @OneToMany(mappedBy = "customer")
    List<GoodsIssueEntity> goodsIssues;


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<GoodsIssueEntity> getGoodsIssues() {
        return goodsIssues;
    }

    public void setGoodsIssues(List<GoodsIssueEntity> goodsIssues) {
        this.goodsIssues = goodsIssues;
    }
}
