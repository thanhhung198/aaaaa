package com.caigicungco.DTO;

import com.caigicungco.entity.ElectronicEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class CategoryDTO extends BaseDTO {

    private String name;

    private String uri;

    private String type;

    private List<ElectronicDTO> electronics;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ElectronicDTO> getElectronics() {
        return electronics;
    }

    public void setElectronics(List<ElectronicDTO> electronics) {
        this.electronics = electronics;
    }
}
