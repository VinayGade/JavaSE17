package streams;

//import beans.Dish;
import beans.enums.Category;
import beans.records.Dish;
import factory.DishFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DishStream {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<Dish> menuCard = DishFactory.populateSpecialMenu();

        // for beans.Dish
        /*
        Map<Category, List<Dish>> vegMenu = menuCard.stream()
                .collect(Collectors.groupingBy(Dish::getCategory,
                        Collectors.filtering(Dish::isVegOnly, Collectors.toList())
                ));
         */

        // Java 17 records
        Map<Category, List<Dish>> vegMenu = menuCard.stream()
                .collect(Collectors.groupingBy(Dish::category,
                        Collectors.filtering(Dish::vegOnly, Collectors.toList())
                ));

        System.out.println("\nVeg Menu Group by category:");
        for(Map.Entry<Category, List<Dish>> vegMenuEntry : vegMenu.entrySet()){
            var category = vegMenuEntry.getKey();
            // prior to Java 17
            /*
            switch(category){
                //case EGG: case CHICKEN : case FISH : case MEAT:  // prior to Java 14
                case EGG, CHICKEN, FISH, MEAT:  // Java 14+
                    continue;
                default:
                    System.out.println(category.name());
                    vegMenuEntry.getValue().forEach(System.out::println);
            }
             */

            switch (category) {
                //case EGG: case CHICKEN : case FISH : case MEAT:  // prior to Java 14
                case STARTER, VEG, FRUIT  -> {  // Java 14+
                    System.out.println(category.name());
                    vegMenuEntry.getValue().forEach(System.out::println);
                }

                /*
                default -> {
                    continue;
                }
                 */

            }
        }
    }
}