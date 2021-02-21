package third;

public class Operation implements Minus, Plus, Mult, Div {
    private float number;

    public Operation(float number) {
        this.number = number;
    }

    @Override
    public void div(float number) {
        if (number == 0) {
            System.out.println("Can't divide by 0");
            return;
        }
        this.number /= number;
    }

    @Override
    public void minus(float number) {
        this.number -= number;
    }

    @Override
    public void mult(float number) {
        this.number *= number;
    }

    @Override
    public void plus(float number) {
        this.number += number;
    }

    public float getNumber() {
        return number;
    }
}
