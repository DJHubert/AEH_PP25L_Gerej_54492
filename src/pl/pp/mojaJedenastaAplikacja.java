import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class mojaJedenastaAplikacja {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        Student bestStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade))
                .orElse(null);

        if (bestStudent != null) {
            System.out.println("Student z najwyższą średnią: " + bestStudent);
        }

        students.sort(Comparator.comparing(Student::getLastName));

        System.out.println("Studenci posortowani według nazwisk:");
        for (Student s : students) {
            System.out.println(s);
        }

        double averageAll = students.stream()
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0.0);

        System.out.printf("Średnia ocen wszystkich studentów: %.2f%n", averageAll);
    }
}

class Student {
    private String indexNumber;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + indexNumber + ") - Average: " +
                String.format("%.2f", getAverageGrade());
    }
}
