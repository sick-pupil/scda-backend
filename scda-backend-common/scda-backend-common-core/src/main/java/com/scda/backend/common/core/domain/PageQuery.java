package com.scda.backend.common.core.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1403515194453067682L;

    private Integer currentPageIndex;

    private Integer pageSize;
}
