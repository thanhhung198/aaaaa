package com.caigicungco.DTO;

import javax.persistence.Column;
import java.util.List;

public class CPUDTO extends BaseDTO{

    private String name;

    private String socket;

    private Integer core;

    private Integer threads;

    private Double maxClock;

    private Double baseClock;

    private Byte cache;

    private List<ElectronicDTO> electronicsDTO;

    public List<ElectronicDTO> getElectronicsDTO() {
        return electronicsDTO;
    }

    public void setElectronicsDTO(List<ElectronicDTO> electronicsDTO) {
        this.electronicsDTO = electronicsDTO;
    }

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



    public CPUDTO gThis() {
        return this;
    }
}
