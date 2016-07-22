package BasicJava.IO;

/**
 * Created by root on 16-2-17.
 */
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Writing to an Object Stream
 * At first, you should get the output stream, and then write to this outputstream is ok.
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            FileOutputStream f = new FileOutputStream("tmp");
            ObjectOutput s = new ObjectOutputStream(f);
            s.writeObject("HelloWorld");
            s.writeObject(new Date());
            s.flush();
            f.close();
        } catch (Exception e) {
            e.getMessage();
        }

    }
}