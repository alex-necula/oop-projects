package actions;

import fileio.Database;

public abstract class AbstractAction implements Runnable {
    private final Database activeEntities;

    protected AbstractAction(final Database activeEntities) {
        this.activeEntities = activeEntities;
    }

    public final Database getActiveEntities() {
        return activeEntities;
    }
}
