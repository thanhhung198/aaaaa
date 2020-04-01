package com.caigicungco.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblproducer")
public class ProducerEntity extends BaseEntity{
    @Column(name = "name") private String name;
    @Column(name = "code")private String code;
    @Column(name = "notes", length = 1028) private String notes;
    @Column(name = "address", length = 512) private String address;


    @OneToMany(mappedBy = "producer",fetch = FetchType.LAZY)
    private List<ElectronicEntity> electronics = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ElectronicEntity> getElectronics() {
        return electronics;
    }

    public void setElectronics(List<ElectronicEntity> electronics) {
        this.electronics = electronics;
    }
}
