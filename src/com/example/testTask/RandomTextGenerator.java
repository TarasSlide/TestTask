package com.example.testTask;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomTextGenerator {

    private static SecureRandom random = new SecureRandom();

    public static String nextText() {
        return new BigInteger(130, random).toString(32);
    }
}