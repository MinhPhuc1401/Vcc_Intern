import java.io.File;
import java.io.FileInputStream;

public class CheckedException  {
    public static void main(String[] args) {
      try{
          File file = new File("not_exist.txt");
          FileInputStream stream = new FileInputStream(file);
      } catch (Exception e){
          throw new RuntimeException("The file does not exist");
      }
    }
}
