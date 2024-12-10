package beans.records;

import beans.interfaces.Bird;

public record Crane(int numberEggs, String name) implements Bird {

    //public Crane(int numberEggs, String name) {} // DOES NOT COMPILE

    //Long constructor
    public Crane(int numberEggs, String name) {
        if (numberEggs < 0)
            throw new IllegalArgumentException();

        this.numberEggs = numberEggs;
        this.name = name;
    }

    //compact constructor
    /*
    public Crane {
        if (name == null || name.length() < 1)
            throw new IllegalArgumentException();
        name = name.substring(0,1).toUpperCase()
                + name.substring(1).toLowerCase();
    }
     */

    // Overloaded Constructors
    public Crane(String firstName, String lastName) {
        this(0, firstName + " " + lastName);
    }

    public Crane(int numberEggs, String firstName, String lastName) {
        this(numberEggs + 1, firstName + " " + lastName);
        numberEggs = 10; // NO EFFECT (applies to parameter, not instance field)
        //this.numberEggs = 20; // DOES NOT COMPILE
    }

    @Override
    public int numberEggs() { return 10; }

    @Override
    public String toString() { return name; }

    /*
    While you can add methods, static fields, and other data types,
    you cannot add instance fields outside the record declaration, even if they are private.
    Doing so defeats the purpose of using a record and could break immutability!
     */
    private static int type = 10;
    //public int size; // DOES NOT COMPILE
    //private boolean friendly; // DOES NOT COMPILE
}
