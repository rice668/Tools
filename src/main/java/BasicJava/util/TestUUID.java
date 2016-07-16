package BasicJava.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by root on 16-7-12.
 */
public class TestUUID {
  public static void main(String[] args) throws Exception {
    for (int i = 0; i < 10; i++) {
      File files = new File("/root/Tools/src/main/java/BasicJava/util/temp/" +
              UUID.randomUUID().toString());
      FileOutputStream fileOutputStream = new FileOutputStream(files);
      fileOutputStream.write("Hello".getBytes());
    }
  }
}
