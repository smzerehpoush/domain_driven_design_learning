package com.mahdiyar.ddd;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public class HashHelper {
    public static final String MD5_HASH_TYPE = "MD5";

    public String getMd5(InputStream stream) throws IOException {
        return getHash(stream, MD5_HASH_TYPE);
    }

    public String getHash(InputStream stream, String hasType) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance(hasType);
            md.update(IOUtils.toByteArray(stream));
            byte[] digest = md.digest();
            return Hex.encodeHexString(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e.getMessage());
        }
    }
}
