import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Folder {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Thay đổi đường dẫn đến thư mục bạn muốn thao tác

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            // Liệt kê các tệp trong thư mục
            File[] files = directory.listFiles();
            if (files != null) {
                System.out.println("Các tệp trong thư mục " + directoryPath + ":");
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Thư mục rỗng.");
            }

            // Đọc nội dung của các tệp văn bản
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên tệp bạn muốn đọc (không bao gồm đường dẫn): ");
            String fileName = scanner.next();

            File fileToRead = new File(directory, fileName);

            if (fileToRead.exists() && fileToRead.isFile()) {
                try {
                    Scanner fileScanner = new Scanner(fileToRead);
                    System.out.println("Nội dung của tệp " + fileName + ":");
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                    fileScanner.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Tệp không tồn tại hoặc không phải là tệp văn bản.");
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không phải là thư mục.");
        }
    }
}
