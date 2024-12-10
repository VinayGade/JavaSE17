package switchcase;

import beans.enums.Season;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Yield {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter Fish Number (1 to 3 ) :");
        int fish = scanner.nextInt();

        System.out.println("Enter Fish Length <10 :");
        int length = scanner.nextInt();

        /*
        * yield : Java 13 : return a value from switch expression
        * */

         /*
        The yield keyword is equivalent to a return statement within a switch expression and
        is used to avoid ambiguity about whether you meant to exit the block or method
        around the switch expression.

        Referring to our second rule for switch expressions, yield statements are not optional
        if the switch statement returns a value.
        *
        * */

        // ** similar to Scala yield in switch and methods

        var name = switch(fish) {
            case 1 -> "Goldfish";
            //case 2 -> "Trout";

            case 2 -> {
                yield "Trout";
            }
            case 3 -> {
                if(length > 10) yield "Blobfish";
                else yield "Green";
            }
            default -> "Swordfish";
        };

        System.out.println("\nFish name :"+name);

        System.out.println("\nfishName(fish, length) :"+fishName(fish, length) );

        var today  = LocalDate.now();
        System.out.println("\nToday is :"+today);

        System.out.println("quarter of year ="+fetchQuarter(today.getMonth()));

    }

    public static String fishName (int fish, int length){
        return switch(fish) {
            case 1 -> "Goldfish";
            case 2 -> "Trout";
            case 3 -> {      // **"if" must have "else" block
                if(length > 10) yield "Blobfish";
                else yield "Green";
            }
            default -> "Swordfish";
        };
    }

    public static String fetchQuarter(Month month){
        return switch (month){
            case JANUARY, FEBRUARY, MARCH -> {

                if(LocalDate.now().isLeapYear())
                    yield "First Quarter (91 Days): February contains 29 days...";
                else
                    yield "First Quarter (90 Days)";

                /*
                var isLeapYear = LocalDate.now().isLeapYear();
                yield (isLeapYear ? "First Quarter : February contains 29 days..." : "First Quarter");
                */

            }
            case APRIL, MAY, JUNE -> "Second Quarter";
            case JULY, AUGUST, SEPTEMBER -> "Third Quarter";
            default -> "Fourth Quarter";
        };
    }
}
