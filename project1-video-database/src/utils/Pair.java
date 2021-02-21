package utils;

import common.Constants;

import java.util.Comparator;
import java.util.List;

public final class Pair<L, R> {
    private final L l;
    private R r;

    public Pair(final L l, final R r) {
        this.l = l;
        this.r = r;
    }

    /**
     * Sorts a list of pairs according to sortType
     *
     * @param list     of pairs that contains an Object and an associated Double
     * @param sortType "asc" or "desc"
     */
    public static void sortPairListByNumber(final List<Pair<Object, Double>> list,
                                            final String sortType) {
        if (sortType.equals(Constants.DESCENDING)) {
            list.sort(Comparator.comparing(p -> -p.getR()));
        } else {
            list.sort(Comparator.comparing(Pair::getR));
        }
    }

    public L getL() {
        return l;
    }

    public R getR() {
        return r;
    }

    public void setR(final R r) {
        this.r = r;
    }
}
