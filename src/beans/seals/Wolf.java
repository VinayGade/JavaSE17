package beans.seals;

public abstract sealed class Wolf permits DareWolf, Timber, MyWolf {

    private String name;
    private int weight;
    private int age;
    private String diet;

    public Wolf(String name, int weight, int age, String diet) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.diet = diet;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", diet='" + diet + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }
}
