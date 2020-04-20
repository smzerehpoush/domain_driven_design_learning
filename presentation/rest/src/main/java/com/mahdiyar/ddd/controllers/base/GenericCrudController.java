package com.mahdiyar.ddd.controllers.base;

import com.mahdiyar.ddd.ModelBase;
import com.mahdiyar.ddd.PagedQuery;
import com.mahdiyar.ddd.PagedResult;
import com.mahdiyar.ddd.RepositoryBase;
import com.mahdiyar.ddd.exceptions.NotFoundException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
        CreateModelRequestDto,
        UpdateModelRequestDto> {

    protected final RepositoryBase<Model, Identity> repository;
    protected final Converter<Model, ModelDto> modelConverter;

    protected abstract Model createModel(CreateModelRequestDto query);

    protected abstract Model updateModel(Model model, UpdateModelRequestDto query);

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create new entity")
    public @ResponseBody
    ModelDto create(@RequestBody @Valid CreateModelRequestDto createDto) {
        Model model = this.createModel(createDto);
        model = this.repository.save(model);
        return this.modelConverter.convert(model);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update an already persisted entity by id")
    public @ResponseBody
    ModelDto update(@PathVariable("id") @NotNull Identity id,
                    @RequestBody @Valid UpdateModelRequestDto updateModelRequestDto) throws NotFoundException {
        Model model = this.repository.findById(id).orElseThrow(NotFoundException::new);
        this.updateModel(model, updateModelRequestDto);
        model = this.repository.save(model);
        return this.modelConverter.convert(model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete an already persisted entity by id")
    public @ResponseBody
    void delete(@PathVariable("id") @NotNull Identity id) throws NotFoundException {
        Model model = this.repository.findById(id).orElseThrow(NotFoundException::new);
        this.repository.delete(model);
    }
}
