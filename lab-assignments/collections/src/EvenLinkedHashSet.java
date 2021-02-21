import java.util.LinkedHashSet;

public class EvenLinkedHashSet extends LinkedHashSet<Integer> {
    @Override
    public boolean add(final Integer integer) {
        if (integer % 2 == 0) {
            super.add(integer);
            return true;
        } else {
            return false;
        }
    }
}
