import java.util.Objects;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return getOrigin() + " " + getFlavor();
    }

    @Override
    // CandyBox objects are equal only if type, flavor and origin are all the
    // same
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(getFlavor(), candyBox.getFlavor()) &&
                Objects.equals(getOrigin(), candyBox.getOrigin());
    }

    public void printDim() {
        System.out.println("No specified dimensions");
    }
}
