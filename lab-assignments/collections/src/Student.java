import java.util.Objects;

public class Student implements Comparable<Student> {
    private final long id;
    private final String name;
    private final String surname;
    private final double averageGrade;

    public Student(long id, String name, String surname, double averageGrade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.averageGrade = averageGrade;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public double getAverageGrade() {
        return this.averageGrade;
    }

    @Override
    public int compareTo(final Student o) {
        if (this.averageGrade == o.averageGrade) {
            if (this.surname.equals(o.surname)) {
                return this.name.compareTo(o.name);
            } else {
                return this.surname.compareTo(o.surname);
            }
        } else {
            return Double.compare(o.averageGrade, this.averageGrade);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Student student = (Student) o;
        return getId() == student.getId() &&
                Double.compare(student.getAverageGrade(), getAverageGrade()) == 0 &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getSurname(), student.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAverageGrade());
    }
}