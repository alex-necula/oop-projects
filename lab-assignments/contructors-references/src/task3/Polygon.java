package task3;

public class Polygon {
    int vertices;
    Point[] pointArray;

    public Polygon(int vertices) {
        this.vertices = vertices;
        this.pointArray = new Point[vertices];
    }

    public Polygon(float[] coords) {
        this(coords.length / 2) ;
        for (int i = 0; i < coords.length; i+=2) {
            this.pointArray[i / 2] = new Point(coords[i], coords[i + 1]);
        }
    }

    public void show() {
        for (Point point : pointArray) {
            point.show();
        }
    }
}
