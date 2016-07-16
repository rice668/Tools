package BasicJava.io;

import com.google.common.base.Charsets;

import java.io.*;

/**
 * Created by root on 16-7-12.
 */
public class PrintWriterTest {
  public static void main(String[] args) throws Exception {
    File file = new File("/root/Tools/src/main/java/BasicJava/io/test.txt");
    
    PrintWriter out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(file), Charsets.UTF_8)));

    PrintWriter out1 = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out, Charsets.UTF_8)));

    out.println("Hello. My Friend");
    out1.println("Hello. My Friend");
    out.flush();
    out1.flush();
    out.close();
    out1.close();
  }
}
