package com.felix.hedgehograce;

import java.util.List;

public class PaginatedListWrapper<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalResults;

    private String sortFields;
    private String sortDirections;
    private List<T> list;

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortFields(String sortFields) {
        this.sortFields = sortFields;
    }

    public void setSortDirections(String sortDirections) {
        this.sortDirections = sortDirections;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public String getSortFields() {
        return sortFields;
    }

    public String getSortDirections() {
        return sortDirections;
    }

    public List<T> getList() {
        return list;
    }
}