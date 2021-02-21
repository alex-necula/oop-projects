package task1_4;

public class Test {
    public static void main(String[] args) {
        Car car = new Car(10000, Car.CarType.BMW, 2010);
        Dealership dealership = new Dealership();

        dealership.getFinalPrice(car);
        dealership.negotiate(car, new Offer() {

            @Override
            public int getDiscount(Car car) {
                int discount = 500;
                System.out.println("Applying Client discount: " + discount +
                        " euros");
                return discount;
            }
        });
    }

    /* S-au generat clasele Car, Dealership, Offer si Test, alaturi de clasele
     * lor interne in formatul OuterClass%InnerClass.class
     * Pentru clasa anonima, s-a generat Test$1.class si Dealership$1.class
     */
}
