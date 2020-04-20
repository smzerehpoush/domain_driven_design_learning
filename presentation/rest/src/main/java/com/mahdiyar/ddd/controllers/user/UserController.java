package com.mahdiyar.ddd.controllers.user;

import com.mahdiyar.ddd.RepositoryBase;
import com.mahdiyar.ddd.controllers.base.Converter;
import com.mahdiyar.ddd.controllers.base.GenericCrudController;
import com.mahdiyar.ddd.controllers.user.dtos.CreateUserRequestDto;
import com.mahdiyar.ddd.controllers.user.dtos.UpdateUserRequestRequestDto;
import com.mahdiyar.ddd.controllers.user.dtos.UserDto;
import com.mahdiyar.ddd.user.UserModel;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Api
@RestController
@RequestMapping("/api/v1/users")
public class UserController extends GenericCrudController<
        UserModel,
        UUID,
        UserDto,
        CreateUserRequestDto,
        UpdateUserRequestRequestDto> {

    public UserController(RepositoryBase<UserModel, UUID> repository, Converter<UserModel, UserDto> modelConverter) {
        super(repository, modelConverter);
    }

    @Override
    protected UserModel createModel(CreateUserRequestDto query) {
        return null;
    }

    @Override
    protected UserModel updateModel(UserModel userModel, UpdateUserRequestRequestDto query) {
        return null;
    }
}
