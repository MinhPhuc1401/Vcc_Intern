import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Serialize đối tượng Person
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            Person person = new Person("Phuc", 21);
            out.writeObject(person);
            System.out.println("Serialize: Đối tượng đã được ghi vào person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize đối tượng Person
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Deserialize: Đối tượng đã được đọc từ person.ser");
            System.out.println("Tên: " + deserializedPerson.getName());
            System.out.println("Tuổi: " + deserializedPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

