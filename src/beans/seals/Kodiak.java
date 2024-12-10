package beans.seals;

import beans.enums.BearType;

public final class Kodiak extends Bear{

    private String diet;

    public String getDiet() {
        return diet;
    }

    public Kodiak(String name, int age, int weight, BearType bearType, String diet) {
        super(name, age, weight, bearType);
        this.diet = diet;
    }
}
