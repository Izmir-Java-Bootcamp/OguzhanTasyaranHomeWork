package Week1HomeWork3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Student first = new Student(
                "oğuzhan",
                1001L,
                1.0,
                new PersonalData(
                        LocalDate.of(1995, 3, 23),
                        1L)
        );
        Student second = new Student(
                "oğuzhan2",
                1002L,
                2.0,
                new PersonalData(
                        LocalDate.of(1995, 3, 23),
                        1L)
        );

        Student third = new Student(
                "oğuzhan3",
                1003L,
                3.0,
                new PersonalData(
                        LocalDate.of(1995, 3, 23),
                        1L)
        );

        Student fourth = new Student(
                "oğuzhan4",
                1004L,
                4.0,
                new PersonalData(
                        LocalDate.of(1995, 3, 23),
                        1L)
        );

        Student fifth = new Student(
                "oğuzhan5",
                5005L,
                5.0,
                new PersonalData(
                        LocalDate.of(1995, 3, 23),
                        1L)
        );

        Course course = new Course("K129", 3);
        course.addStudent(first);
        course.addStudent(second);
        course.addStudent(third);
        course.addStudent(fourth);

        course.list();

        course.increaseCapacity();

        course.addStudent(fourth);
        course.addStudent(fifth);

        course.list();

        course.dropStudent(fifth);

        course.list();

        System.out.println(course.getNumberOfStudent());

        System.out.println(course.getBestStudent().getPd().getBirthDate().getYear());

        Course k130 = new Course("k130");

        Arrays.stream(course.getStudents()).filter(Objects::nonNull).forEach(k130::addStudent);

        course.clear();

        System.out.println(course.dropStudent(fifth));

        k130.list();

        k130.dropStudent(k130.getBestStudent());

        k130.list();

        System.out.println(k130.getYoungest().getGpa());
    }

}