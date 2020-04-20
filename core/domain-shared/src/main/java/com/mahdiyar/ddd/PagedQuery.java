package com.mahdiyar.ddd;

import lombok.Setter;

import java.util.Optional;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Setter
public class PagedQuery {
    private Integer page;
    private Integer pageSize;
    private SortDirection sortDirection;

    public Integer getPage() {
        return Optional.of(this.page).orElse(0);
    }

    public Integer getPageSize() {
        return Optional.of(this.pageSize).orElse(0);
    }

    public SortDirection getSortDirection() {
        return Optional.of(this.sortDirection).orElse(SortDirection.ASC);
    }
}
