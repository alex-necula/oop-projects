package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public class ConcreteCalculator implements Calculator {

    private void checkParameters(final Double nr1, final Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }
    }
    private void checkExceptions(final Double result) {
        if (result.equals(Double.NEGATIVE_INFINITY)) {
            throw new UnderflowException();
        } else if (result.equals(Double.POSITIVE_INFINITY)) {
            throw new OverflowException();
        }
    }

    @Override
    public Double add(final Double nr1, final Double nr2) {
        checkParameters(nr1, nr2);
        Double result = nr1 + nr2;
        checkExceptions(result);
        return result;
    }

    @Override
    public Double divide(final Double nr1, final Double nr2) {
        checkParameters(nr1, nr2);
        Double result = nr1 / nr2;
        checkExceptions(result);
        return result;
    }

    @Override
    public Double average(final Collection<Double> numbers) {
        Double sum = (double) 0;
        for (var number : numbers) {
            sum = add(sum, number);
        }
        return divide(sum, (double) numbers.size());
    }
}
