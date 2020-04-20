package com.mahdiyar.ddd;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public class TestRandomString {
    @Test
    public void testRandomString() {
        RandomString randomString = new RandomString();
        Assert.assertNotNull(randomString.nextString());
    }
}
