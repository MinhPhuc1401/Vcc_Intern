import java.io.*;

public class InOut {
    public static void main(String[] args) {
        String textFileName = "textfile.txt";
        String binaryFileName = "binaryfile.dat";

        // Ghi tệp văn bản
        try {
            FileWriter textWriter = new FileWriter(textFileName);
            textWriter.write("Đây là nội dung tệp văn bản.");
            textWriter.close();
            System.out.println("Đã ghi tệp văn bản.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc tệp văn bản
        try {
            FileReader textReader = new FileReader(textFileName);
            int character;
            System.out.println("Nội dung tệp văn bản:");
            while ((character = textReader.read()) != -1) {
                System.out.print((char) character);
            }
            textReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ghi tệp binary
        try {
            FileOutputStream binaryOutput = new FileOutputStream(binaryFileName);
            byte[] data = { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100 };
            binaryOutput.write(data);
            binaryOutput.close();
            System.out.println("\nĐã ghi tệp binary.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc tệp binary
        try {
            FileInputStream binaryInput = new FileInputStream(binaryFileName);
            System.out.println("Nội dung tệp binary:");
            int byteRead;
            while ((byteRead = binaryInput.read()) != -1) {
                System.out.print((char) byteRead);
            }
            binaryInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
