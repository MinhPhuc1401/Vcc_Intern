import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DataStructuresExample {
    public static void main(String[] args) {
        // Tạo một danh bạ sử dụng HashMap
        HashMap<String, String> phoneBook = new HashMap<>();

        // Thêm dữ liệu vào danh bạ
        phoneBook.put("Bố", "1900-1001");
        phoneBook.put("Mẹ", "1900-1002");
        phoneBook.put("Người iu", "1900-1009");

        // In danh bạ
        System.out.println("Danh bạ:");
        for (String name : phoneBook.keySet()) {
            String phoneNumber = phoneBook.get(name);
            System.out.println(name + ": " + phoneNumber);
        }

        // Sử dụng HashSet để lưu danh sách các thành phố
        HashSet<String> cities = new HashSet<>();

        cities.add("Hà Nội");
        cities.add("Hải Dương");
        cities.add("Hải Phòng");

        System.out.println("\nDanh sách thành phố:");
        for (String city : cities) {
            System.out.println(city);
        }

        // Sử dụng ArrayList để lưu danh sách số nguyên
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("\nDanh sách số nguyên:");
        for (int number : numbers) {
            System.out.println(number);
        }
        
        
    }
}

