package actions.producer;

import actions.AbstractAction;
import entities.MonthlyStat;
import fileio.Database;

import java.util.ArrayList;
import java.util.List;

public final class CreateMonthlyStatAction extends AbstractAction {
    private final int currentMonth;

    public CreateMonthlyStatAction(final Database activeEntities, final int currentMonth) {
        super(activeEntities);
        this.currentMonth = currentMonth;
    }

    @Override
    public void run() {
        for (var producer : getActiveEntities().getProducers()) {
            List<Integer> distributorsIds = new ArrayList<>();
            for (var distributor : producer.getDistributors()) {
                distributorsIds.add(distributor.getId());
            }
            producer.addMonthlyStat(new MonthlyStat(currentMonth, distributorsIds));
        }
    }
}
