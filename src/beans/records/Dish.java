package beans.records;

import beans.enums.Category;

public record Dish(
        int id,
        String name,
        int calories,
        double price,
        Category category,
        boolean vegOnly) {
}
