import java.util.ArrayList;

public class CandyBag {
    private ArrayList<CandyBox> candyBoxes;

    public CandyBag(ArrayList<CandyBox> candies) {
        this.candyBoxes = candies;
    }

    public ArrayList<CandyBox> getCandyBoxes() {
        return candyBoxes;
    }

    public void setCandyBoxes(ArrayList<CandyBox> candyBoxes) {
        this.candyBoxes = candyBoxes;
    }
}
