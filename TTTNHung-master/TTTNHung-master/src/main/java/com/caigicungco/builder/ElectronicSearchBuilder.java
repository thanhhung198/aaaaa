package com.caigicungco.builder;

import javax.persistence.Column;

public class ElectronicSearchBuilder {

    private String name;
    private String type;
    private int ram;
    private String secondaryMamory;
    private double sizeDisplay; // đơn vị "
    private String cpu;
    private String gpu;
    private String hightlight;

    public String getName() {
        return name;
    }

    public ElectronicSearchBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public ElectronicSearchBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public int getRam() {
        return ram;
    }

    public ElectronicSearchBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public String getSecondaryMamory() {
        return secondaryMamory;
    }

    public ElectronicSearchBuilder setSecondaryMamory(String secondaryMamory) {
        this.secondaryMamory = secondaryMamory;
        return this;
    }

    public double getSizeDisplay() {
        return sizeDisplay;
    }

    public ElectronicSearchBuilder setSizeDisplay(double sizeDisplay) {
        this.sizeDisplay = sizeDisplay;
        return this;
    }

    public String getCpu() {
        return cpu;
    }

    public ElectronicSearchBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public String getGpu() {
        return gpu;
    }

    public ElectronicSearchBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }
}
