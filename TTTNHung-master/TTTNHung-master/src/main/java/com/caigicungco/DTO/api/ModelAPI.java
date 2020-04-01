package com.caigicungco.DTO.api;

import com.caigicungco.DTO.BaseDTO;
import com.caigicungco.DTO.PageDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.ArrayList;
import java.util.List;

public class ModelAPI <T extends BaseDTO> {
    public static final String STATUS_OK = "ok";
    public static final String STATUS_ERROR = "error";
    private String status;
    private List<T> data;
    private PageDTO paging;

    public ModelAPI() {
        data = new ArrayList<>();
    }

    public ModelAPI(String status, List<T> data) {
        this.status = status;
        this.data = data;
    }

    public PageDTO getPaging() {
        return paging;
    }

    public void setPaging(PageDTO paging) {
        this.paging = paging;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
