package com;

import java.util.Random;

public class RandomStringGenerator {

    private final Random generator = new Random();

    private int size;
    private char[] alphabet;

    public RandomStringGenerator(final int s, final String a) {
        this.size = s;
        this.alphabet = a.toCharArray();
    }

    public String next() {
        char[] randString = new char[size];

        for (int i = 0; i < size; i++) {
            randString[i] = alphabet[generator.nextInt(alphabet.length)];
        }

        return new String(randString);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public Random getGenerator() {
        return generator;
    }
}
