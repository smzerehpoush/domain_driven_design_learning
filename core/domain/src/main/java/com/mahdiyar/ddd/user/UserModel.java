package com.mahdiyar.ddd.user;

import com.mahdiyar.ddd.ModelBase;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Getter
@Setter
public class UserModel extends ModelBase<UUID> {
    private String username;
    private String name;

    public UserModel(UUID id, String username, String name) {
        super(id);
        this.username = username;
        this.name = name;
    }
}
