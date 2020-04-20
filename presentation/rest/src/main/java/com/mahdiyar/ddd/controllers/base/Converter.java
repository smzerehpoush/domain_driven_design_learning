package com.mahdiyar.ddd.controllers.base;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public interface Converter<Source, Destination> {
    Destination convert(Source source);
}
