import java.util.Scanner;

public class Problem3_DeliveryFeeCalculator {

    static abstract class Delivery {
        double weight;
        double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double getFee();
    }

    static class Standard extends Delivery {

        Standard(double weight, double distance) {
            super(weight, distance);
        }

        double getFee() {
            return 5 + (0.50 * weight) + (0.10 * distance);
        }
    }

    static class Express extends Delivery {

        Express(double weight, double distance) {
            super(weight, distance);
        }

        double getFee() {
            return 15 + (1.00 * weight) + (0.20 * distance);
        }
    }

    static class International extends Delivery {

        double customsFee;

        International(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        double getFee() {
            return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            if (type.equals("STANDARD")) {
                delivery = new Standard(weight, distance);

            } else if (type.equals("EXPRESS")) {
                delivery = new Express(weight, distance);

            } else {
                double customsFee = sc.nextDouble();
                delivery = new International(weight, distance, customsFee);
            }

            double fee = delivery.getFee();

            System.out.printf("%s: %.2f%n", type, fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
