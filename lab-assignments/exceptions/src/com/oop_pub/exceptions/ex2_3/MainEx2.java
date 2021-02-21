package com.oop_pub.exceptions.ex2_3;

import java.util.List;

public class MainEx2 {
    public static void main(String[] args) {
        Calculator calculator = new ConcreteCalculator();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(List.of(1d, 2d, 3d, 4d)));

        // Test edge cases that would throw exceptions

        System.out.println(calculator.add(null, 1d));
        System.out.println(calculator.divide(1d, 0d));
        System.out.println(calculator.average(List.of(Double.NEGATIVE_INFINITY, -1d)));

        /* Alegerea fireasca pentru aceasta implementare de calculator
        sunt exceptiile unchecked (RuntimeException) deoarece nu ar avea sens sa
        continuam calculul in cazul intalnirii unei astfel de exceptii, cum ar
        fi impartirea la 0.
         */
    }
}
