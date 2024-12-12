package streams;

import java.util.*;

public class StudentSorting {

    public static void main(String[] args) {
        Student s1 = new Student("Vinay", 3, 75);
        Student s2 = new Student("Vivek", 2, 65);
        Student s3 = new Student("Rahul", 3, 75);

        Student s4 = new Student("Ravi", 2, 68);
        Student s5 = new Student("Sujata", 4, 80);

        List<Student> students = new ArrayList<>(List.of(s1, s2, s3, s4, s5));

        /*
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
         */

        Collections.sort(students, (student1, student2) ->
                student2.percent() > student1.percent() ? 1 : -1
        );

        students.sort(Comparator.comparingInt(Student::percent)
                .reversed()
                .thenComparing(Student::name)
        );

        students.forEach(System.out::println);

        List<String> languages = List.of("Java", "C++", "JavaScript", "Python", "Scala", "Go","Ruby","Rust" );

        // Create a mutable copy of the immutable list
        List<String> mutableLanguages = new ArrayList<>(languages);

        List<String> popularLanguages = Arrays.asList("Java", "C++", "JavaScript", "Python", "Go");

        //Collections.sort(languages); // java.lang.UnsupportedOperationException   ... immutable collection
        Collections.sort(mutableLanguages);

        Collections.sort(popularLanguages, Comparator.comparingInt(String::length));

        System.out.println("\nsort languages: ascending:");

        popularLanguages.forEach(System.out::println);

        popularLanguages.sort(Comparator.comparingInt(String::length).reversed());

        System.out.println("\nsort languages: descending:");

        popularLanguages.forEach(System.out::println);

        System.out.println("\nsort all languages: ascending:");

        mutableLanguages.forEach(System.out::println);
    }
}
