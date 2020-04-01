package com.caigicungco.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblcategory",uniqueConstraints = @UniqueConstraint(columnNames = "uri"))
public class CategoryEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "uri")
    private String uri;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ElectronicEntity> electronics;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<ElectronicEntity> getElectronics() {
        return electronics;
    }

    public void setElectronics(List<ElectronicEntity> electronics) {
        this.electronics = electronics;
    }
}
