package beans.seals;

import beans.enums.BearType;

public sealed class Bear permits Kodiak, Panda {

    String name;
    int age;
    int weight;

    BearType bearType;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public BearType getBearType(){
        return this.bearType;
    }

    public Bear(String name, int age, int weight, BearType bearType) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.bearType = bearType;
    }

    @Override
    public String toString() {
        return "Bear{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", bearType=" + bearType +
                '}';
    }
}
