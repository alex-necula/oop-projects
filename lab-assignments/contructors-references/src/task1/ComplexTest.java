package task1;

public class ComplexTest {
    public static void main(String[] args) {
        Complex complex1 = new Complex();
        complex1.showNumber();

        Complex complex2 = new Complex(10, 20);
        complex2.showNumber();

        Complex complex3 = new Complex(complex2);
        complex3.showNumber();

        complex3.addWithComplex(complex2);
        complex3.showNumber();
    }
}
