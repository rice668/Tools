package XMl_OP_Xiaolong;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * If there is not data in the file then delete it.
 */
public class JudgeBytesInFile {
  public static void main(String[] args) {
    File root = new File("/root/Tools/src/main/java/XMl_OP_Xiaolong/appid/");
    File[] files = root.listFiles();
    System.out.println(files.length);
    for (int i = 0; i < files.length; i++) {
      try {
        InputStream inputStream = new FileInputStream(new File(files[i].getAbsolutePath()));
        int num = inputStream.read();
        if (num == -1) {
          files[i].delete();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
