package com.caigicungco.DTO;

import com.caigicungco.entity.BaseEntity;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.persistence.Column;
import java.util.List;

// base có id thôi
public class ElectronicDTO extends BaseDTO {
    private String name;
    private String pictureTitle;
    private int height;
    private int width;
    private int thickness;// dày
    private int guarantee; // bảo hành theo số tháng
    private String type;
    private int status;//còn bán / hết / ngừng kinh doanh
    private String[] highlights;// 1-HOT|2-BanChay|3-NoiBat
    private String[] describes; // miêu tả - array
    private String ram;
    private String[] secondaryMamory;// bộ nhớ ngoài
    private String[] portConnector;// cổng kết nối
    private String display;

    private String camera;

    private String cameraSelfie;

    private String operatingSystem;

    private String pin;
    private String uri;

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCode() {
        return uri;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private GPUDTO gpu;

    private CPUDTO cpu;

    private ProducerDTO producer;

    private List<VersionDTO> versions;

    //private List<GoodsIssue_ElectronicDTO> goodsIssue_electronics;

    public GPUDTO getGpu() {
        return gpu;
    }

    public void setGpu(GPUDTO gpu) {
        this.gpu = gpu;
    }

    public CPUDTO getCpu() {
        return cpu;
    }

    public void setCpu(CPUDTO cpu) {
        this.cpu = cpu;
    }

    public ProducerDTO getProducer() {
        return producer;
    }

    public void setProducer(ProducerDTO producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureTitle() {
        return pictureTitle;
    }

    public void setPictureTitle(String pictureTitle) {
        this.pictureTitle = pictureTitle;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String[] getHighlights() {
        return highlights;
    }

    public void setHighlights(String[] highlights) {
        this.highlights = highlights;
    }

    public String[] getDescribes() {
        return describes;
    }

    public void setDescribes(String[] describes) {
        this.describes = describes;
    }



    public String[] getSecondaryMamory() {
        return secondaryMamory;
    }

    public void setSecondaryMamory(String[] secondaryMamory) {
        this.secondaryMamory = secondaryMamory;
    }

    public String[] getPortConnector() {
        return portConnector;
    }

    public void setPortConnector(String[] portConnector) {
        this.portConnector = portConnector;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getCameraSelfie() {
        return cameraSelfie;
    }

    public void setCameraSelfie(String cameraSelfie) {
        this.cameraSelfie = cameraSelfie;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<VersionDTO> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionDTO> versions) {
        this.versions = versions;
    }

}
