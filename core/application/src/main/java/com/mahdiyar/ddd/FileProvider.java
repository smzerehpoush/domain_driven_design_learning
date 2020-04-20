package com.mahdiyar.ddd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public interface FileProvider {
    InputStream readFile(String path) throws FileNotFoundException;

    void writeFile(String path, InputStream stream) throws IOException;

    String getHash(String path) throws IOException;

    Long getSize(String path) throws IOException;

    String getHash(InputStream stream) throws IOException;
}
