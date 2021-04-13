package com.ash.ik.backtrack;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Test {

    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        .toCharArray();

    public static void generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        IntStream tokenStream = secureRandom.ints(32, 0, ALPHABET.length);
        String token = tokenStream.collect(StringBuilder::new, (builder, arg) -> builder.append(ALPHABET[arg]),
            StringBuilder::append).toString();

        System.out.println(token);
    }

    public static void main(String[] args) throws Exception {
        String str = "hey\u00A3";
        byte[] charset = str.getBytes("UTF-8");
        String result = new String(charset, "UTF-8");
        System.out.println(result);

        generateToken();
    }
}
