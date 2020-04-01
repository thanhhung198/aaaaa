package com.caigicungco.entity;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblcpu")
public class CPUEntity extends BaseEntity{
    @Column(name = "name") private String name;

    @Column(name = "socket") private String socket;

    @Column(name = "core") private Integer core;

    @Column(name = "threads") private Integer threads;

    @Column(name = "max_clock") private Double maxClock;

    @Column(name = "base_clock") private Double baseClock;

    @Column(name = "cache") private Byte cache;



    @OneToMany(mappedBy = "cpu",fetch = FetchType.LAZY)
    private List<ElectronicEntity> electronics;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public Double getMaxClock() {
        return maxClock;
    }

    public void setMaxClock(Double maxClock) {
        this.maxClock = maxClock;
    }

    public Double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(Double baseClock) {
        this.baseClock = baseClock;
    }

    public Byte getCache() {
        return cache;
    }

    public void setCache(Byte cache) {
        this.cache = cache;
    }

    public List<ElectronicEntity> getElectronics() {
        return electronics;
    }

    public void setElectronics(List<ElectronicEntity> electronics) {
        this.electronics = electronics;
    }
}
