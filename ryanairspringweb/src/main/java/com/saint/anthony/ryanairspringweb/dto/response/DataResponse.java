package com.saint.anthony.ryanairspringweb.dto.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class DataResponse<T>  {

    private List<T> data;

    private Integer page;

    private Integer size;

    private Long totalEl;

    public DataResponse(List<T> data, Page page) {
        this.data = data;
        this.size = page.getSize();
        this.page = page.getNumber();
        this.totalEl = page.getTotalElements();
    }
}
