package beans.seals;

import beans.enums.BearType;

public non-sealed class Panda extends Bear{
    public Panda(String name, int age, int weight, BearType bearType) {
        super(name, age, weight, bearType);
    }
}