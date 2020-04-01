package com.caigicungco.DTO;

import java.util.List;

public class GPUDTO extends BaseDTO{
    public GPUDTO gThis(){
        return this;
    }

    private String name;

    private Integer core;

    private Double maxClock;

    private Double baseClock;

    private List<ElectronicDTO> electronicsDTO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
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

    public List<ElectronicDTO> getElectronicsDTO() {
        return electronicsDTO;
    }

    public void setElectronicsDTO(List<ElectronicDTO> electronicsDTO) {
        this.electronicsDTO = electronicsDTO;
    }
}
