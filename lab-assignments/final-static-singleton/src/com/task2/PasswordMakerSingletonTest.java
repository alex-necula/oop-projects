package com.task2;

/* In a multi-thread program, Singleton pattern with lazy implementation can
 * cause issues if multiple threads are inside the if loop at the same time.
 * It will destroy the singleton pattern and both threads will get the
 * different instances of singleton class.
 * Additional checks have to be added to fix this.
 *
 * A Singleton pattern with eager implementation may decrease performance
 * because only one thread can use it at a certain time
 *
 * Source: https://taskinoor.wordpress.com/2011/04/18/singleton_multithreaded/
 */

public class PasswordMakerSingletonTest {
    public static void main(String[] args) {
        PasswordMakerSingleton passwordMakerSingleton = PasswordMakerSingleton.getInstance();
        passwordMakerSingleton.setName("Alex");
        System.out.println(passwordMakerSingleton.getPassword());

        PasswordMakerSingleton.getInstance();
        PasswordMakerSingleton.getInstance();

        System.out.println(PasswordMakerSingleton.getCounter());
    }
}
