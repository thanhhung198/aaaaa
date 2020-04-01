package com.caigicungco.DTO;

import com.caigicungco.entity.ElectronicEntity;


public class VersionDTO extends BaseDTO{
    private String color;
    private String pictures[]; // arr
    private Integer price;
    private Long electronic_id;
    private Integer amount;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getElectronic_id() {
        return electronic_id;
    }

    public void setElectronic_id(Long electronic_id) {
        this.electronic_id = electronic_id;
    }
}
