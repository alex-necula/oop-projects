package task2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Alex");
        student1.setYear(2);
        Student student2 = new Student();
        student2.setName("Rares");
        student2.setYear(2);
        Student student3 = new Student();
        student3.setName("Gigi");
        student3.setYear(3);

        Student[] students = {student1, student2, student3};

        Course course = new Course();

        course.setTitle("POO");
        course.setDescription("Programare Orientata pe Obiecte");
        course.setStudents(students);

        if (args.length == 0) {
            System.out.println("Command line argument - year - is missing");
            System.exit(1);
        }

        var list = course.filterYear(Integer.parseInt(args[0]));

        for (Student s : list) {
            System.out.println(s.toString());
        }
    }
}
