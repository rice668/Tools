package BasicJava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by root on 16-7-11.
 */
public class CopyFile {

  public static void copyFile(File in, File out) throws Exception {
    FileInputStream fis = new FileInputStream(in);
    FileOutputStream fos = new FileOutputStream(out);
    byte[] buf = new byte[1024];
    int i = 0;
    while ((i = fis.read(buf)) != -1) {
      fos.write(buf, 0, i);
    }
    fis.close();
    fos.close();
  }


  public static void main(String[] args) {

  }
}
