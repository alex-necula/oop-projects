package actions;

import fileio.Database;
import updates.MonthlyUpdate;

public abstract class AbstractUpdateAction extends AbstractAction {
    private final MonthlyUpdate monthlyUpdate;

    protected AbstractUpdateAction(final Database activeEntities,
                                   final MonthlyUpdate monthlyUpdate) {
        super(activeEntities);
        this.monthlyUpdate = monthlyUpdate;
    }

    public final MonthlyUpdate getMonthlyUpdate() {
        return monthlyUpdate;
    }
}
