import com.google.gson.Gson;

class Student {
    public String name;
    public int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class JSONExample {
    public static void main(String[] args) {
        Student student = new Student("Phuc", 21);
        Gson gson = new Gson();
        
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}
