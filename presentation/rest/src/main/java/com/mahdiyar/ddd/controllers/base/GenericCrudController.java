package com.mahdiyar.ddd.controllers.base;

import com.mahdiyar.ddd.ModelBase;
import com.mahdiyar.ddd.PagedQuery;
import com.mahdiyar.ddd.PagedResult;
import com.mahdiyar.ddd.RepositoryBase;
import com.mahdiyar.ddd.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@RequiredArgsConstructor
public abstract class GenericCrudController<
        Model extends ModelBase<Identity>,
        Identity,
        ModelDto extends ModelDtoBase<Model, Identity>,
        GetPagedQuery extends PagedQuery,
        CreateDto,
        UpdateDto> {

    protected final RepositoryBase<Model, Identity> repository;
    protected final Converter<Model, ModelDto> modelConverter;

    protected abstract List<Model> queryModels(GetPagedQuery query);

    @GetMapping("/{id}")
    public @ResponseBody
    ModelDto get(@PathVariable("id") Identity id) throws NotFoundException {
        Model model = this.repository.findById(id).orElseThrow(NotFoundException::new);
        return this.modelConverter.convert(model);
    }

    @GetMapping
    public @ResponseBody
    PagedResult<ModelDto> get(@RequestParam PagedQuery pagedQuery) throws NotFoundException {
        List<ModelDto> models = this.repository.findAll(pagedQuery)
                .stream()
                .map(this.modelConverter::convert)
                .collect(Collectors.toList());
        long totalRecords = this.repository.count();
        return new PagedResult<>(models, pagedQuery, totalRecords);
    }
}
