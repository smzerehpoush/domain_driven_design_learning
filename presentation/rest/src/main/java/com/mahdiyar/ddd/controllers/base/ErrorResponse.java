package com.mahdiyar.ddd.controllers.base;

import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class ErrorResponse {
    private String message;
    private String localizedMessage;
    private String code;
    private String developerMessage;
}