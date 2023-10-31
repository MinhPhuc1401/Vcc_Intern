class Singleton {
    private static Singleton instance;

    // Để ngăn việc tạo đối tượng từ bên ngoài lớp
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Thêm các phương thức và thuộc tính của Singleton ở đây
}

public class SingletonExample {
    public static void main(String[] args) {
        // Lấy thể hiện Singleton
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Kiểm tra xem cả hai thể hiện có cùng tham chiếu
        if (singleton1 == singleton2) {
            System.out.println("singleton1 và singleton2 là cùng một thể hiện.");
        }
    }
}
