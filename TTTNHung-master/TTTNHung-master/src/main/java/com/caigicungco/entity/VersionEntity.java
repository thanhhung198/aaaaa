package com.caigicungco.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblversion")
public class VersionEntity extends BaseEntity{

    @Column(name = "color") private String color;

    @Column(name = "picture") private String picture; // arr

    @Column(name = "price")
    private Integer price;

    @Column(name = "amount")
    private Integer amount;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "electronic_id")
    private ElectronicEntity electronic = new ElectronicEntity();



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ElectronicEntity getElectronicEntity() {
        return electronic;
    }

    public void setElectronicEntity(ElectronicEntity electronic) {
        this.electronic = electronic;
    }
}
