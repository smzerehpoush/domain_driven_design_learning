package com.mahdiyar.ddd.exceptions;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException() {
    }
}
