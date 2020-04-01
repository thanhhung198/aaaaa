package com.caigicungco.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "tblelectronic",uniqueConstraints = @UniqueConstraint(columnNames = "uri"))
public class ElectronicEntity extends BaseEntity{


    @Column(name = "uri") private String uri;

    @Column(name = "name") private String name;

    @Column(name = "picture_title") private String pictureTitle;

    @Column(name = "height") private int height;

    @Column(name = "width") private int width;

    @Column(name = "thickness") private int thickness;// dày

    @Column(name = "guarantee") private int guarantee; // bảo hành theo số tháng

    @Column(name = "type") private String type;

    @Column(name = "status") private int status;//còn bán hay hết

    @Column(name = "highlights") private String highlights;// 1-HOT|2-BanChay|3-NoiBat

    @Column(name = "describes",length = 1028) private String describes; // miêu tả - array

    @Column(name = "ram") private String ram;

    @Column(name = "secondary_mamory") private String secondaryMamory;// bộ nhớ ngoài

    @Column(name = "port_connector",length = 1028) private String portConnector;// cổng kết nối

    @Column(name = "display") private String display;

    @Column(name = "camera")
    private String camera;

    @Column(name = "camera_selfie")
    private String cameraSelfie;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "pin")
    private String pin;


    @ManyToOne
    @JoinColumn(name = "category_id")
    @Fetch(FetchMode.JOIN)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gpu_id")
    private GPUEntity gpu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cpu_id")
    private CPUEntity cpu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id")
    private ProducerEntity producer;

    @OneToMany(mappedBy = "electronic",fetch = FetchType.LAZY)
    private List<ShopCart_ElectronicEntity> shopCart_electronics;

    @OneToMany(mappedBy = "electronic",cascade = CascadeType.ALL)
    private List<VersionEntity> versions;

    @OneToMany(mappedBy = "electronic",fetch = FetchType.LAZY)
    private List<GoodsIssue_ElectronicEntity> goodsIssue_electronics;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSecondaryMamory() {
        return secondaryMamory;
    }

    public void setSecondaryMamory(String secondaryMamory) {
        this.secondaryMamory = secondaryMamory;
    }

    public String getPortConnector() {
        return portConnector;
    }

    public void setPortConnector(String portConnector) {
        this.portConnector = portConnector;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public GPUEntity getGpu() {
        return gpu;
    }

    public void setGpu(GPUEntity gpu) {
        this.gpu = gpu;
    }

    public CPUEntity getCpu() {
        return cpu;
    }

    public void setCpu(CPUEntity cpu) {
        this.cpu = cpu;
    }

    public ProducerEntity getProducer() {
        return producer;
    }

    public void setProducer(ProducerEntity producer) {
        this.producer = producer;
    }

    public List<VersionEntity> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionEntity> versions) {
        this.versions = versions;
    }

    public List<GoodsIssue_ElectronicEntity> getGoodsIssue_electronics() {
        return goodsIssue_electronics;
    }

    public void setGoodsIssue_electronics(List<GoodsIssue_ElectronicEntity> goodsIssue_electronics) {
        this.goodsIssue_electronics = goodsIssue_electronics;
    }


}
