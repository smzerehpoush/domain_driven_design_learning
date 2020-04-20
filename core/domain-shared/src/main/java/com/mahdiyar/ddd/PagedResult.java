package com.mahdiyar.ddd;

import lombok.Data;

import java.util.List;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class PagedResult<Content> {
    private List<Content> contents;
    private int page;
    private int pageSize;
    private long totalCount;

    public PagedResult(List<Content> contents, PagedQuery pagedQuery, long totalCount) {
        this.contents = contents;
        this.page = pagedQuery.getPage();
        this.pageSize = pagedQuery.getPageSize();
        this.totalCount = totalCount;
    }
}
