package beans.records;

import beans.enums.Genre;

import java.time.Year;
import java.util.Comparator;
import java.util.List;

public record CD(String artist, String title, int noOfTracks,
                 Year year, Genre genre) implements Comparable<CD> {


    // Additional get methods:
    public boolean isPop() {
        return this.genre == Genre.POP;
    }

    public boolean isJazz() {
        return this.genre == Genre.JAZZ;
    }

    public boolean isOther() {
        return this.genre == Genre.OTHER;
    }

    @Override
    public int compareTo(CD other) {
        return Comparator.comparing(CD::artist)
                .thenComparing(CD::title)
                .thenComparing(CD::noOfTracks)
                .thenComparing(CD::year)
                .thenComparing(CD::genre)
                .compare(this, other);
    }

    @Override
    public String toString() {
        return String.format("<%s, \"%s\", %d, %s, %s>",
                this.artist, this.title, this.noOfTracks, this.year, this.genre);
    }

    // Some ready-made CDs.
    public static final CD cd0 = new CD("Babe Rexha", "All Your Fault", 6, Year.of(2016), Genre.JAZZ);

    public static final CD cd1 = new CD("Camila Cabello", "Romance", 8, Year.of(2020), Genre.POP);

    public static final CD cd2 = new CD("David Guetta", "Nothing but the Beat", 10, Year.of(2011), Genre.POP);

    public static final CD cd3 = new CD("Sia", "Bang My Head", 5, Year.of(2021), Genre.JAZZ);

    public static final CD cd4 = new CD("Billie Eilish", "Happier Than Ever", 16, Year.of(2021), Genre.POP);

    public static final CD cd5 = new CD("Selena Gomez", "Calm Down", 6, Year.of(2023), Genre.OTHER);

    // A fixed-size list of CDs.
    public static final List<CD> cdList = List.of(cd0, cd1, cd2, cd3, cd4, cd5);

    // An array of CDs.
    public static final CD[] cdArray = {cd0, cd1, cd2, cd3, cd4, cd5};

}
