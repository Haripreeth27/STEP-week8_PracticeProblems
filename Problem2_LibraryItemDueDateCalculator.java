import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problem2_LibraryItemDueDateCalculator {

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getLoanDays();

        String getDueDate() {
            LocalDate currentDate = LocalDate.of(2023, 10, 26);
            LocalDate dueDate = currentDate.plusDays(getLoanDays());

            return dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int getLoanDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }

        int getLoanDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int getLoanDays() {
            return 3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(
                item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}