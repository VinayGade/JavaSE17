package streams;

import beans.enums.Gender;
import beans.records.CD;
import beans.records.Employee;
import beans.records.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GroupCollect {

    public static void main(String[] args) {

        //GROUP BY

        System.out.println("");

        //COLLECTING THEN
        //Collectors.teeing() Java 12

        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        Optional<Integer> min = numbers.stream().collect(minBy(Integer::compareTo));
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        // do something useful with min and max
        String minMaxStr = numbers.stream().collect(teeing(
                minBy(Integer::compareTo), // The first collector
                maxBy(Integer::compareTo), // The second collector
                (minimum, maximum) -> {// Receives the result from those collectors and combines them
                    return minimum.get()+" "+maximum.get();
                }
        ));

        System.out.println("\nOriginal list: "+numbers);
        System.out.println("\nFind min and max from list in 1 pass:");
        System.out.println("\nCollectors.teeing() in Java 12");
        System.out.println(minMaxStr);

        //List of person
        List<Person> people = Arrays.asList(
                new Person(1, "Vinay", 30, Gender.MALE),
                new Person(2, "Rahul", 35, Gender.MALE),
                new Person(3, "Divya", 28, Gender.FEMALE),
                new Person(4, "Smita", 41, Gender.FEMALE));

        HashMap<String, Person> youngestOldestPeopleMap = people.stream().collect(
                Collectors.teeing(
                        Collectors.minBy(Comparator.comparingInt(Person::age)),
                        Collectors.maxBy(Comparator.comparingInt(Person::age)),
                        (e1, e2) -> {
                            HashMap<String, Person> map = new HashMap();
                            map.put("MIN", e1.get());
                            map.put("MAX", e2.get());
                            return map;
                        }
                )
        );

        System.out.println(youngestOldestPeopleMap);

        HashMap<String, Object> result = people.stream().collect(
                Collectors.teeing(
                        Collectors.filtering(e -> e.age() > 200, Collectors.toList()),
                        Collectors.filtering(e -> e.age() > 200, Collectors.counting()),
                        (list, count) -> {
                            HashMap<String, Object> map = new HashMap();
                            map.put("list", list);
                            map.put("count", count);
                            return map;
                        }
                ));

        System.out.println(result);
        // PARTITION
    }
}
