package com.caigicungco.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblgpu")
public class GPUEntity extends BaseEntity{
    @Column(name = "name") private String name;

    @Column(name = "core") private Integer core;

    @Column(name = "max_clock") private Double maxClock;

    @Column(name = "base_clock") private Double baseClock;

    @OneToMany(mappedBy = "gpu",fetch = FetchType.LAZY)
    private List<ElectronicEntity> electronics;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public Double getMaxClock() {
        return maxClock;
    }

    public void setMaxClock(double maxClock) {
        this.maxClock = maxClock;
    }

    public Double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(double baseClock) {
        this.baseClock = baseClock;
    }

    public List<ElectronicEntity> getElectronics() {
        return electronics;
    }

    public void setElectronics(List<ElectronicEntity> electronics) {
        this.electronics = electronics;
    }
}
