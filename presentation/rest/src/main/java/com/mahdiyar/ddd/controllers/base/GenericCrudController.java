package com.mahdiyar.ddd.controllers.base;

import com.mahdiyar.ddd.ModelBase;
import com.mahdiyar.ddd.RepositoryBase;
import com.mahdiyar.ddd.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public class GenericCrudController<
        Model extends ModelBase<Identity>,
        Identity,
        GetDto extends ModelDto<Model, Identity>,
        GetListDto extends ModelDto<Model, Identity>,
        GetPagedQuery extends PagedQueryModel,
        CreateDto,
        UpdateDto> {

    protected final RepositoryBase<Model, Identity> repository;
    protected final Converter<Model, GetDto> modelConverter;
    protected final Converter<Model, GetListDto> listModelConverter;


    @GetMapping("/{id}")
    public @ResponseBody
    GetDto get(@PathVariable("id") Identity id) throws NotFoundException {
        Model model = this.repository.findById(id).orElseThrow(NotFoundException::new);
        return this.modelConverter.convert(model);
    }

    @GetMapping
    public @ResponseBody
    GetDto get(@RequestParam PagedQueryModel page) throws NotFoundException {
        Model model = this.repository.findById(id).orElseThrow(NotFoundException::new);
        return this.modelConverter.convert(model);
    }
}
