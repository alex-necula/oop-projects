package entities;

public final class Penalty {
    private final int sum;
    private final Payee payee;

    public Penalty(final int sum, final Payee payee) {
        this.sum = sum;
        this.payee = payee;
    }

    public int getSum() {
        return sum;
    }

    public Payee getPayee() {
        return payee;
    }
}
