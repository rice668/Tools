package BasicJava.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * FileOutputStream is meant for writing streams of raw bytes
 * such as image data. For writing streams of characters, consider using
 * FileWriter.
 */
public class BufferedWriterTest {
  public static void main(String[] args) throws Exception {
    File out = new File("/root/Tools/src/main/java/BasicJava/io/BufferedWriter.txt");
    FileOutputStream fos = new FileOutputStream(out);
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
    bufferedWriter.write("Test-BufferedWriter");
    bufferedWriter.close();
  }
}
