package com.mahdiyar.ddd;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public class TestHashHelper {


    @Test
    public void testMd5Hash() {
        HashHelper hashHelper = new HashHelper();
        InputStream inputStream =
                new ByteArrayInputStream("this is test".getBytes(StandardCharsets.UTF_8));
        try {
            assertEquals("8C6D115258631625B625486F81B09532", hashHelper.getMd5(inputStream));
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testCustomHash() {
        HashHelper hashHelper = new HashHelper();
        InputStream inputStream =
                new ByteArrayInputStream("this is test".getBytes(StandardCharsets.UTF_8));
        try {
            assertEquals("4F9C3633E8859BBE74114C4F82AA23ADA90DC9A7B59643FD36451239EE1163EA",
                    hashHelper.getHash(inputStream, "SHA-256"));
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testUnknownHashAlgorithm() {
        HashHelper hashHelper = new HashHelper();
        try {
            hashHelper.getHash(null, "FOO-BAR");
            fail();
        } catch (IOException e) {
//            this is ok to throw exception for unknown algorithm
        }
    }
}
