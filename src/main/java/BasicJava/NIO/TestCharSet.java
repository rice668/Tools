package BasicJava.NIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by root on 16-7-12.
 */
public class TestCharSet {
  public static void main(String[] args) throws Exception {
    Process pid = Runtime.getRuntime().exec("ls /root");
    BufferedReader in = new BufferedReader(
            new InputStreamReader(pid.getInputStream(), Charset.forName("UTF-8")));
      while (true) {
        String line = in.readLine();
        System.out.println(line);
        if (line == null) {
          break;
        }
      }
  }
}
