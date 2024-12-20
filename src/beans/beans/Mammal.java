package beans.beans;

public abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        System.out.print(getType() + " ");
        System.out.println( speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}