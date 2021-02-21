package com.task1;

public class PasswordMakerTest {
    public static void main(String[] args) {
        PasswordMaker passwordMaker = new PasswordMaker("Alex");
        System.out.println(passwordMaker.getPassword());
    }
}
