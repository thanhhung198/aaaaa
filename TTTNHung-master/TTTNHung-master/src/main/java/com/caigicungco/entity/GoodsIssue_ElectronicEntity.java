package com.caigicungco.entity;


import javax.persistence.*;

@Entity
@Table(name = "goods_issue_electronic", uniqueConstraints = @UniqueConstraint(columnNames = {"electronic_id","electronic_id"}))
public class GoodsIssue_ElectronicEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "electronic_id")
    private ElectronicEntity electronic;

    @ManyToOne
    @JoinColumn(name = "goods_issue_id")
    private GoodsIssueEntity goodsIssue;

    @Column(name = "amount")
    private int amount;// số lượng


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElectronicEntity getElectronic() {
        return electronic;
    }

    public void setElectronic(ElectronicEntity electronic) {
        this.electronic = electronic;
    }

    public GoodsIssueEntity getGoodsIssue() {
        return goodsIssue;
    }

    public void setGoodsIssue(GoodsIssueEntity goodsIssue) {
        this.goodsIssue = goodsIssue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
