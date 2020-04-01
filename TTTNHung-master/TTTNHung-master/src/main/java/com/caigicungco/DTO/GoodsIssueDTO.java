package com.caigicungco.DTO;

import java.util.List;

public class GoodsIssueDTO extends BaseDTO{
    private List<GoodsIssue_ElectronicDTO> goodsIssue_electronicEntities;

    private Long customer_id;

    public List<GoodsIssue_ElectronicDTO> getGoodsIssue_electronicEntities() {
        return goodsIssue_electronicEntities;
    }

    public void setGoodsIssue_electronicEntities(List<GoodsIssue_ElectronicDTO> goodsIssue_electronicEntities) {
        this.goodsIssue_electronicEntities = goodsIssue_electronicEntities;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
