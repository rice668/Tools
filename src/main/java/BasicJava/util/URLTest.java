package BasicJava.util;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public class URLTest {
  public static void main(String[] args) throws Exception {
    File file = new File("/root/Tools/src/main/java/BasicJava/util/TestCollections.java");
    Path path = file.toPath();
    URL url = file.toURL();
    System.out.println(path.toString());
    System.out.println(url.toString());
  }
}
