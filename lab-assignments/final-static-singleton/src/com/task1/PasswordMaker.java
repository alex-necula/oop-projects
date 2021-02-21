package com.task1;

import java.util.Random;
import com.RandomStringGenerator;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 9;
    private static final RandomStringGenerator RANDOM_GENERATOR = new
            RandomStringGenerator(20, "abcdefghijklmnopqrstuvwxyz");
    private static final String MAGIC_STRING = RANDOM_GENERATOR.next();

    private final String name;

    public PasswordMaker(String name) {
        this.name = name;
    }

    public String getPassword() {
        char[] randAlphabet = new char[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randAlphabet[i] = MAGIC_STRING.charAt(random.nextInt(MAGIC_STRING.length()));
        }
        RANDOM_GENERATOR.setSize(MAGIC_NUMBER);
        RANDOM_GENERATOR.setAlphabet(randAlphabet);
        return RANDOM_GENERATOR.next() + name.length() + random.nextInt(101);
    }
}
