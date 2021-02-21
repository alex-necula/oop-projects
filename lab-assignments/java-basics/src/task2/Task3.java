package task2;

import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setName("Alex");
        student2.setName("Alex");
        student1.setYear(2);
        student2.setYear(2);
        System.out.println(student1.equals(student2));
    }
}
