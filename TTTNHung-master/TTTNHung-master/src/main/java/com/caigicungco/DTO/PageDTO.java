package com.caigicungco.DTO;

public class PageDTO {
    Long totalItems;
    Integer totalPages;
    Integer page;

    public PageDTO(Long totalItem, Integer totalPage, Integer page) {
        this.totalItems = totalItem;
        this.totalPages = totalPage;
        this.page = page;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
