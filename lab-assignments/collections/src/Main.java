import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        // Task 2
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Alexandru", "Necula", 10));
        studentList.add(new Student(2, "Rares", "Petruc", 10));
        studentList.add(new Student(3, "Razvan", "Popescu", 5.9));
        studentList.add(new Student(4, "Stefan", "Popescu", 5.9));
        studentList.add(new Student(5, "Matei", "Necula", 9.8));

        // Task 3
        studentList.forEach(System.out::println); // before sort
        studentList.sort(Comparator.naturalOrder());
        System.out.println();
        studentList.forEach(System.out::println); // after sort

        // Task 4
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(
                Comparator.comparingLong(Student::getId));
        studentPriorityQueue.addAll(studentList);
        System.out.println();
        while (!studentPriorityQueue.isEmpty()) {
            System.out.println(studentPriorityQueue.poll()); // sorted after id
        }

        // Task 6
        Map<Student, List<String>> courseMap = new HashMap<>();
        courseMap.put(studentList.get(0), new LinkedList<>(Arrays.asList("AA", "OOP")));
        courseMap.put(studentList.get(1), new LinkedList<>(Arrays.asList("PC", "M1")));
        courseMap.put(studentList.get(2), new LinkedList<>(Arrays.asList("M2", "M1")));
        courseMap.put(studentList.get(3), new LinkedList<>(Arrays.asList("PC", "M1", "M2")));
        courseMap.put(studentList.get(4), new LinkedList<>(Arrays.asList("PC", "M1", "TS")));

        System.out.println();
        courseMap.forEach((key, value) -> System.out.println(key + " " + value));

        // Task 7
        EvenLinkedHashSet set = new EvenLinkedHashSet();
        set.addAll(Arrays.asList(40, 5, 19, 30, 18, 90));
        System.out.println();
        set.forEach(System.out::println);

        // Using LinkedHashSet preserves the order of the inserted elements
        // Using HashSet doesn't preserve the order
        // Using TreeSet will sort the elements in ascending order
    }
}
