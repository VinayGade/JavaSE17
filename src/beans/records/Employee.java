package beans.records;

import beans.enums.Gender;

public record Employee(String empId, String fullName, String location, String department, int age,
                       Gender gender, float salary, int experience) {
}
