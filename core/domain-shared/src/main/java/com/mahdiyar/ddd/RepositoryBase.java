package com.mahdiyar.ddd;

import java.util.List;
import java.util.Optional;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public interface RepositoryBase<Model extends ModelBase<Identity>, Identity> {
    Optional<Model> findById(Identity id);

    List<Model> findAll(int page, int pageSize, SortDirection sortDirection);

    List<Model> findAll(PagedQuery pagedQuery);

    boolean existsById(Identity id);

    long count();

    void deleteById(Identity id);

    void delete(Model model);

    Model save(Model model);

    List<Model> saveAll(List<Model> models);
}
