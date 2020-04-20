package com.mahdiyar.ddd.controllers.user.dtos;

import com.mahdiyar.ddd.controllers.base.ModelDtoBase;
import com.mahdiyar.ddd.user.UserModel;
import lombok.Getter;

import java.util.UUID;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Getter
public class UserDto extends ModelDtoBase<UserModel, UUID> {
    private String username;
    private String name;

    public UserDto(UserModel userModel) {
        super(userModel);
        this.username = userModel.getUsername();
        this.name = userModel.getName();
    }
}
