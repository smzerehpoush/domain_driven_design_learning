package com.mahdiyar.ddd.controllers.base;

import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class PagedQueryModel {
    private Integer page;
    private Integer pageSize;
    private SortDirection sortDirection;
}
