package com.mahdiyar.ddd.controllers.user.converters;

import com.mahdiyar.ddd.controllers.base.Converter;
import com.mahdiyar.ddd.controllers.user.dtos.UserDto;
import com.mahdiyar.ddd.user.UserModel;
import org.springframework.stereotype.Component;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Component
public class UserConverter implements Converter<UserModel, UserDto> {
    @Override
    public UserDto convert(UserModel userModel) {
        return new UserDto(userModel);
    }
}
