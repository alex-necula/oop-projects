package entities;

public interface Payee {
    /**
     * Receive money
     *
     * @param sum to be added to budget
     */
    void getPaid(int sum);
}
