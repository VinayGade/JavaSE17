package sealed;

import beans.enums.BearType;
import beans.seals.*;

public class AnimalsDemo {

    public static void main(String[] args) {

        Bear panda = new Panda("Teddy", 5, 50, BearType.HARBIVORE);

        String bearDiet = "Fish, Chicken, hares, rabbits,";

        Bear scary = new Kodiak("Scary", 15, 110, BearType.CARNIVORE, bearDiet);

        System.out.println(panda.toString());

        System.out.println(scary.toString());

        String wolfDiet = "deer, bison, moose, hares, rabbits, fish";

        Wolf dareWolf = new DareWolf("Lone Wolf", 15, 10, wolfDiet);

        Wolf huskie = new Timber("Scooby", 18, 9, "hares, rabbits, fish, chicken");

        Wolf redWolf = new MyWolf("Red Wolf", 16, 10, "deer, hares, rabbits, fish");

        System.out.println(dareWolf.toString());
        System.out.println(huskie.toString());
        System.out.println(redWolf.toString());
    }
}