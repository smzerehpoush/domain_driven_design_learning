package com.mahdiyar.ddd.controllers.base;

import com.mahdiyar.ddd.ModelBase;
import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public abstract class ModelDtoBase<Model extends ModelBase<Identity>, Identity> {
    private Identity id;

    protected ModelDtoBase(Model model) {
        this.id = model.getId();
    }
}
