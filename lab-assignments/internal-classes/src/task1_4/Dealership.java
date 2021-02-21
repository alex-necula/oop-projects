package task1_4;

import java.util.Calendar;
import java.util.Random;

public class Dealership {

    private static class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int discount;
            switch (car.getCarType()) {
                case BMW -> discount = (int) (car.getPrice() * 0.05);
                case DACIA -> discount = (int) (car.getPrice() * 0.1);
                case AUDI -> discount = (int) (car.getPrice() * 0.01);
                default -> discount = 0;
            }
            System.out.println("Applying Brand discount: " + discount + " euros");
            return discount;
        }
    }

    private static class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int discount = (Calendar.getInstance().get(Calendar.YEAR) - car.getYear()) * 100;
            System.out.println("Applying Dealer discount: " + discount + " euros");
            return discount;
        }
    }

    private static class SpecialOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            Random rand = new Random();
            int discount = rand.nextInt(301);
            System.out.println("Applying Special discount: " + discount + " euros");
            return discount;
        }
    }

    public void getFinalPrice(Car car) {
        int initialPrice = car.getPrice();
        int discounts = (new SpecialOffer().getDiscount(car))
                + (new DealerOffer().getDiscount(car))
                + (new BrandOffer().getDiscount(car));
        car.setPrice(initialPrice - discounts);
        System.out.println("Final price: " + car.getPrice() + " euros");
    }

    void negotiate(Car car, Offer offer) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            int initialPrice = car.getPrice();
            car.setPrice(initialPrice - offer.getDiscount(car));
        }
        System.out.println("Final price after negotiation: " + car.getPrice() + " euros");
    }
}
