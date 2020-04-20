package com.mahdiyar.ddd.client;

import com.mahdiyar.ddd.ModelBase;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Getter
public class ClientModel extends ModelBase<UUID> {
    private String name;

    public ClientModel(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("name can not be null or empty");
        }
        this.name = name;
    }
}
