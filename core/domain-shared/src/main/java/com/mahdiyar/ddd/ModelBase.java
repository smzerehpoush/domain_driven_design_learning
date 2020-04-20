package com.mahdiyar.ddd;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class ModelBase<Identity> {
    private Identity id;
    private LocalDateTime creationTime;

    public ModelBase(Identity id) {
        this.id = id;
        this.creationTime = LocalDateTime.now();
    }
}
