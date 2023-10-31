import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class HashSetExample {
    public static void main(String[] args) {
        // Tạo một HashSet chứa các đối tượng Person
        Set<Person> personSet = new HashSet<>();

        // Thêm các đối tượng Person vào HashSet
        Person person1 = new Person("Phuc", 21);
        Person person2 = new Person("Nga", 20);
        Person person3 = new Person("Phuc", 21); // Trùng lặp với person1

        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3); // Không được thêm vào vì đã tồn tại person1 có cùng giá trị

        // In ra các phần tử trong HashSet
        for (Person person : personSet) {
            System.out.println("Tên: " + person.getName() + ", Tuổi: " + person.getAge());
        }
    }
}
