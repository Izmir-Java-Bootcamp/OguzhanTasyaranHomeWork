package Week1HomeWork3;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Course {
    private String name;
    private Student[] students;
    private int capacity;
    private int numberOfStudent;

    public Course(String name) {
        this.name = name;
        this.capacity = 40;
        this.numberOfStudent = 0;
        this.students = new Student[capacity];
    }

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.numberOfStudent = 0;
        this.students = new Student[capacity];
    }

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public boolean addStudent(Student student) {
        if (numberOfStudent + 1 < capacity && !isStudentExist(student.getId())) {
            students[numberOfStudent] = student;
            numberOfStudent += 1;
            return true;
        }
        return false;
    }

    public boolean dropStudent(Student student) {
        boolean foundFlag = false;
        for (int i = 0; i < numberOfStudent; i++) {
            if (students[i] != null && students[i].getId() == student.getId()) {
                students[i] = null;
                foundFlag = true;
            }
            if (foundFlag) {
                students[i - 1] = student;
            }
        }
        if (foundFlag) {
            numberOfStudent -= 1;
        }
        return foundFlag;
    }

    private boolean isStudentExist(long id) {
        return Arrays.stream(students).anyMatch(it -> it != null && it.getId() == id);
    }

    public void increaseCapacity() {
        this.capacity += 5;
        Student[] newStudentList = new Student[this.capacity];
        System.arraycopy(students, 0, newStudentList, 0, students.length);
        this.students = newStudentList;
    }

    public Student getBestStudent() {
        return Arrays.stream(students).filter(it -> it != null).max(Comparator.comparing(Student::getGpa)).get();
    }

    public Student getYoungest() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate earliestDate = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
        Student result = students[0];
        for (Student s : students) {
            if (s != null && s.getPd().getBirthDate().isBefore(earliestDate)) {
                result = s;
            }
        }
        return result;
    }

    public void clear() {
        this.students = new Student[capacity];
    }

    public void list() {
        for (Student s : students) {
            if (s != null) {
                System.out.println(s.toString());
            }
        }
    }
}