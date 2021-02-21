public class Area {
    private CandyBag candyBag;
    private int number;
    private String street;

    public Area() {
    }

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    public CandyBag getCandyBag() {
        return candyBag;
    }

    public void setCandyBag(CandyBag candyBag) {
        this.candyBag = candyBag;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println("Address: " + number + " " + street);
        System.out.println("Happy Birthday!");
        System.out.println("Your gift has " + candyBag.getCandyBoxes().size() + " Candy Boxes");

        /*for (CandyBox candyBox: candyBag.getCandyBoxes()) {
            System.out.println(candyBox.toString());
            if (candyBox instanceof Lindt) {
                ((Lindt) candyBox).printLindtDim();
            }
            if (candyBox instanceof Baravelli) {
                ((Baravelli) candyBox).printBaravelliDim();
            }
            if (candyBox instanceof ChocAmor) {
                ((ChocAmor) candyBox).printChocAmorDim();
            }
        }*/

        for (CandyBox candyBox : candyBag.getCandyBoxes()) {
            System.out.println(candyBox.toString());
            candyBox.printDim();
        }
    }
}
