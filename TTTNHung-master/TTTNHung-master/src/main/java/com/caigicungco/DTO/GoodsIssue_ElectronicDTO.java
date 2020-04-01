package com.caigicungco.DTO;

public class GoodsIssue_ElectronicDTO{

    private Long id;
    private Long electronic_id;
    private Long goodsIssue_id;

    private int amount;// số lượng

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getElectronic_id() {
        return electronic_id;
    }

    public void setElectronic_id(Long electronic_id) {
        this.electronic_id = electronic_id;
    }

    public Long getGoodsIssue_id() {
        return goodsIssue_id;
    }

    public void setGoodsIssue_id(Long goodsIssue_id) {
        this.goodsIssue_id = goodsIssue_id;
    }
}
