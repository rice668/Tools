package BasicJava.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by root on 16-7-13.
 */
public class FileWriterTest {
  public static void main(String[] args) throws Exception {
    FileWriter fileWriter = new FileWriter("/root/Tools/src/main/java/BasicJava/io/filewriter.txt");
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write("do some stuff");
    bufferedWriter.flush();
    bufferedWriter.close(); // you must specific this line, or it wont write any data to disk.
  }
}
