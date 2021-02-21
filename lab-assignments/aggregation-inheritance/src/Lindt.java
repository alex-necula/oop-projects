public class Lindt extends CandyBox {
    private float length;
    private float width;
    private float depth;

    public Lindt() {
    }

    public Lindt(String flavor, String origin, float length, float width,
                 float depth) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    @Override
    public float getVolume() {
        return length * width * depth;
    }

    @Override
    public String toString() {
        return "The Lindt " + getOrigin() + " " + getFlavor() + " has volume "
                + getVolume();
    }

    /*public void printLindtDim() {
        System.out.println("Length is " + length + ", width is " + width + " " +
                "and depth is " + depth);
    }*/

    @Override
    public void printDim() {
        System.out.println("Length is " + length + ", width is " + width + " " +
                "and depth is " + depth);
    }
}
