import com.google.gson.Gson;

class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

public class GSONExample {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Phuc\",\"age\":21}";
        Gson gson = new Gson();

        Person person = gson.fromJson(jsonString, Person.class);

        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}

