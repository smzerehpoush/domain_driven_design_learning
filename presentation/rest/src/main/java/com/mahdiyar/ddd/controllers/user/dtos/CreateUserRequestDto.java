package com.mahdiyar.ddd.controllers.user.dtos;

import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class CreateUserRequestDto {
    private String username;
    private String name;
}
