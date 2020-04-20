package com.mahdiyar.ddd.controllers.base;

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
}
