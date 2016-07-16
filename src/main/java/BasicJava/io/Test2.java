package BasicJava.io;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 * Deserialize
 * Read from an Object Stream
 *
 */
public class Test2 {
  public static void main(String[] args) {
    try {
      FileInputStream fileInputStream = new FileInputStream("tmp");
      ObjectInputStream s = new ObjectInputStream(fileInputStream);
      String s1 = (String)s.readObject();
      Date date = (Date)s.readObject();
      System.out.println(date);
    }catch(Exception e) {
      e.getMessage();
    }
  }
}