public class ChocAmor extends CandyBox {
    private float length;

    public ChocAmor() {
    }

    public ChocAmor(String flavor, String origin, float length) {
        super(flavor, origin);
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public float getVolume() {
        return (float) Math.pow(length, 3);
    }

    @Override
    public String toString() {
        return "The ChocAmor " + getOrigin() + " " + getFlavor() + " has " +
                "volume " + getVolume();
    }

    /*public void printChocAmorDim() {
        System.out.println("Length is " + length);
    }*/

    @Override
    public void printDim() {
        System.out.println("Length is " + length);
    }
}
