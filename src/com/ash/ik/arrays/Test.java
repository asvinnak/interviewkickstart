package com.ash.ik.arrays;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Test {

    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        .toCharArray();
    public static void main(String[] args) {

        SecureRandom secureRandom = new SecureRandom();
        IntStream tokenStream = secureRandom.ints(32, 0, ALPHABET.length);
        String token = tokenStream.collect(StringBuilder::new, (builder, arg) -> builder.append(ALPHABET[arg]),
            StringBuilder::append).toString();


        System.out.println(token);
    }

}
