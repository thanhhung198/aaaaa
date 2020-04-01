package com.caigicungco.DTO;

import java.util.List;

public class CustomerDTO extends BaseDTO{

    private String fullname;

    private String phone;

    private int totalMoney;

    private List<GoodsIssueDTO> goodsIssues;

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

    public List<GoodsIssueDTO> getGoodsIssues() {
        return goodsIssues;
    }

    public void setGoodsIssues(List<GoodsIssueDTO> goodsIssues) {
        this.goodsIssues = goodsIssues;
    }
}
