package action.query;

import action.Action;

import java.util.List;
import java.util.StringJoiner;

public abstract class Query implements Action {

    private final String sortType;

    protected Query(final String sortType) {
        this.sortType = sortType;
    }

    protected final String getSortType() {
        return sortType;
    }

    protected final String resultMessage(final List<String> names,
                                         final int queryNumber) {
        StringJoiner stringJoiner = new StringJoiner(", ");

        int resultNumber = Math.min(queryNumber, names.size());

        for (int i = 0; i < resultNumber; i++) {
            stringJoiner.add(names.get(i));
        }

        return "Query result: [" + stringJoiner.toString() + "]";
    }
}
