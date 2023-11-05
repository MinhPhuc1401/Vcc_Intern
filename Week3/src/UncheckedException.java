import java.util.Scanner;

class UncheckedException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int numbers[] = {10, 20, 30};
            int index = input.nextInt();
            System.out.println(numbers[index]);
        } catch (Exception e) {
                e.printStackTrace();
        }
        input.close();
    }
}

