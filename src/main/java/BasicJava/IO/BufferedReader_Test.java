package BasicJava.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class BufferedReader_Test {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://cat.ctripcorp.com/cat/r/t?op=graphs&domain=110402&date=2016062109&ip=All&type=URL&forceDownload=xml");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line = null;
    File file = new File("/root/Tools/src/main/java/BasicJava/text.xml");
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    while ((line = reader.readLine()) != null) {
      fileOutputStream.write(line.getBytes());
      fileOutputStream.write("\n".getBytes());
    }
  }
}
