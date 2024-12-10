package beans.records;

import beans.enums.Gender;

public record Person(int id, String name, int age, Gender gender) {
}
