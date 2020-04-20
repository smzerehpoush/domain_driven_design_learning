package com.mahdiyar.ddd.controllers.user;

import com.mahdiyar.ddd.PagedQuery;
import com.mahdiyar.ddd.controllers.base.GenericCrudController;
import com.mahdiyar.ddd.user.UserModel;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Api
@RestController
@RequestMapping("/api/v1/users")
public class UserController extends GenericCrudController {
    @Override
    protected List<UserModel> queryModels(PagedQuery pagedQueryModel) {
        return null;
    }
}
