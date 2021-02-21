import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Baravelli b = new Baravelli("Milk", "Romania", 1, 2);
        Lindt l = new Lindt("Strawberry", "France", 2, 3, 4);
        ChocAmor c = new ChocAmor("Almond", "UK", 3);

        // Task 1 and 2 tests
        System.out.println(b.toString());
        System.out.println(l.toString());
        System.out.println(c.toString());

        System.out.println();

        // Task 3 tests
        Lindt l1 = new Lindt("Strawberry", "France", 2, 3, 4);
        Lindt l2 = new Lindt("Strawberry", "UK", 2, 3, 4);
        Lindt l3 = new Lindt("Strawberry", "UK", 2, 3, 5);
        System.out.println(l1.equals(l)); // should be true
        System.out.println(l1.equals(l2)); // should be false

        // shows true because we do not test depth equality in parent class
        // CandyBox
        System.out.println(l2.equals(l3));
        System.out.println();

        // Task 4,5,6 tests
        ArrayList<CandyBox> candyBoxes = new ArrayList<>();
        candyBoxes.add(b);
        candyBoxes.add(l);
        candyBoxes.add(c);

        CandyBag candyBag = new CandyBag(candyBoxes);
        Area area = new Area(candyBag, 13, "Splaiul Unirii");
        area.getBirthdayCard();
    }
}
