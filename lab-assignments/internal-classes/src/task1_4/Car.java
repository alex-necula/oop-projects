package task1_4;

public class Car {
    public Car(int price, CarType carType, int year) {
        this.price = price;
        this.carType = carType;
        this.year = year;
    }

    public enum CarType {
        BMW, DACIA, AUDI
    }

    private int price;
    private final CarType carType;
    private final int year;

    public int getPrice() {
        return price;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getYear() {
        return year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", carType=" + carType +
                ", year=" + year +
                '}';
    }
}
