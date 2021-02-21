package entities;

import java.util.List;
import java.util.stream.Collectors;

public final class MonthlyStat {
    private int month;
    private List<Integer> distributorsIds;

    public MonthlyStat(final int month, final List<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds.stream().sorted().collect(Collectors.toList());
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(final int month) {
        this.month = month;
    }

    public List<Integer> getDistributorsIds() {
        return distributorsIds;
    }

    public void setDistributorsIds(final List<Integer> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }
}
