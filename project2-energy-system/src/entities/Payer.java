package entities;

public interface Payer {
    /**
     * Pay to known payee
     *
     * @param sum to be paid
     */
    void pay(Payee payee, int sum);

    /**
     * Pay to unknown payee
     *
     * @param sum to be paid
     */
    void pay(int sum);
}
