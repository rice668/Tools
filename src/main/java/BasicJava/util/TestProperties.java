package BasicJava.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by root on 16-7-12.
 */
public class TestProperties {

  /**
   * Deal with files
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    Properties info = new Properties();
    InputStream inputStream = new FileInputStream
            (new File("/root/Tools/src/main/java/BasicJava/util/jvm.properties"));
    info.load(inputStream);
    String runTimeName = info.getProperty("java.runtime.name");
    System.out.println(runTimeName);
  }
}