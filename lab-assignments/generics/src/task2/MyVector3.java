package task2;

import java.util.Arrays;

public class MyVector3 implements Summable {
    private final int[] vector;

    public MyVector3() {
        this.vector = new int[3];
    }

    public MyVector3(final int[] vector) {
        if (vector.length == 3) {
            this.vector = vector;
        } else {
            this.vector = new int[3];
        }
    }

    @Override
    public void addValue(final Summable value) {
        if (value instanceof MyVector3) {
            for (int i = 0; i <= 2; i++) {
                this.vector[i] += ((MyVector3) value).vector[i];
            }
        }
    }

    @Override
    public String toString() {
        return "MyVector3{" +
                "vector=" + Arrays.toString(vector) +
                '}';
    }
}
