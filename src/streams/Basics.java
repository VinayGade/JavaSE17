package streams;

import java.time.Year;
import java.util.List;

public class Basics {

    public static void main(String[] args) {

        List<String> values = List.of("2001", "1999", "2021");

        for(String s: values){
            Year year = Year.parse(s);
            if(year.isAfter(Year.of(2000)))
                System.out.print(" "+year);
        }

        System.out.println("\nYears after 2000: ");
        // using Stream
        values.stream()
                .map(s -> Year.parse(s))
                .filter(y->y.isAfter(Year.of(2000)))
                .forEach(System.out::println);
    }
}
