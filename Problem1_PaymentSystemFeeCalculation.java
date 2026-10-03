import java.util.Scanner;

public class Problem1_PaymentSystemFeeCalculation {

    static abstract class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double getFinalAmount();
    }

    static class Card extends Payment {
        Card(double amount) {
            super(amount);
        }

        double getFinalAmount() {
            return amount * 1.02;
        }
    }

    static class Wallet extends Payment {
        Wallet(double amount) {
            super(amount);
        }

        double getFinalAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }

        double getFinalAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new Card(amount);
            } else if (type.equals("WALLET")) {
                payment = new Wallet(amount);
            } else {
                payment = new BankTransfer(amount);
            }

            double finalAmount = payment.getFinalAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}