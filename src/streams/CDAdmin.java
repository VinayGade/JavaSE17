package streams;

import beans.records.CD;

import java.util.List;
import java.util.stream.Collectors;

public class CDAdmin {

    public static void main(String[] args) {

        List<CD> cdList = CD.cdList;

        System.out.println(" Artist     \t\t\t\tTitle \t\t\tTracks\t        \tYear        Genre");

        for(int i=0; i< cdList.size(); i++){

            CD cd = cdList.get(i);

            String cdToString = String.format("%-20s%-25s%-12d%-15s%-15s",
                    cd.artist(), cd.title(), cd.noOfTracks(), cd.year(), cd.genre());

            System.out.printf("cd%d: %s%n", i, cdToString);
        }

        System.out.println("\n Pop albums from CD:");

        List<CD> cds = List.of(CD.cd0, CD.cd1, CD.cd2, CD.cd3, CD.cd4, CD.cd5);

        List<CD> popSongs = cds.stream()                       //1. Stream creation.
                .filter(CD::isPop)                             //2. Intermediate operation
                .toList(); //.collect(Collectors.toList());    //3. Terminal operation

        popSongs.forEach(System.out::println);
    }
}
