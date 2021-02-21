public class Baravelli extends CandyBox {
    private float radius;
    private float height;

    public Baravelli() {
    }

    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public float getVolume() {
        return (float) (Math.PI * Math.pow(radius, 2) * height);
    }

    @Override
    public String toString() {
        return "The Baravelli " + getOrigin() + " " + getFlavor() + " has " +
                "volume " + getVolume();
    }

    /*public void printBaravelliDim() {
        System.out.println("Radius is " + radius + " and height is " + height);
    }*/

    @Override
    public void printDim() {
        System.out.println("Radius is " + radius + " and height is " + height);
    }
}
