package fileio;

import com.fasterxml.jackson.annotation.JsonSetter;
import updates.MonthlyUpdate;

import java.util.List;

public final class Input {
    private int numberOfTurns;
    private Database database;
    private List<MonthlyUpdate> monthlyUpdates;

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public Database getDatabase() {
        return database;
    }

    @JsonSetter("initialData")
    public void setDatabase(final Database database) {
        this.database = database;
    }

    public List<MonthlyUpdate> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    public void setMonthlyUpdates(final List<MonthlyUpdate> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }
}




