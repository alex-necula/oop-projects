package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Consumer extends AbstractFinancialEntity {
    private static final double PENALTY_MARGIN = 1.2;
    private int monthlyIncome;
    private Contract contract = null;
    private Penalty penalty = null;

    @JsonIgnore
    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    @JsonProperty
    public void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    /**
     * @return true if consumer has an assigned contract
     */
    public boolean hasContract() {
        return contract != null;
    }

    @JsonIgnore
    public Contract getContract() {
        return contract;
    }

    public void setContract(final Contract contract) {
        this.contract = contract;
    }

    /**
     * Removes contract from consumer
     */
    public void removeContract() {
        this.contract = null;
    }

    /**
     * @return true if consumer has previous penalty
     */
    public boolean hasPenalty() {
        return penalty != null;
    }

    @JsonIgnore
    public Penalty getPenalty() {
        return penalty;
    }

    @Override
    public void pay(final Payee payee, final int sum) {
        if (sum > getBudget()) {
            if (hasPenalty()) {
                becomeBankrupt();
            } else {
                penalty = new Penalty((int) (sum * PENALTY_MARGIN), payee);
            }
        } else {
            super.pay(payee, sum);
        }
    }

    @Override
    public void pay(final int sum) {
        if (sum > getBudget()) {
            becomeBankrupt();
        } else {
            setBudget(getBudget() - sum);
            // Consumers' budget can not be negative in ref files
        }
    }
}
