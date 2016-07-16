package XMl_OP_Xiaolong;

import java.io.*;

/**
 * Calculate how many lines in those file and select the file which meets the condition.
 */
public class DiscardFiles {
  public static void main(String[] args) throws Exception {
    File root = new File("/root/Downloads/Match/");
    File[] files = root.listFiles();
    for (File file : files) {
      int i = 0;
      FileReader fileReader = new FileReader(file);
      BufferedReader reader = new BufferedReader(fileReader);
      String line = null;
      while ((line = reader.readLine()) != null) {
        i++;
      }
      if (i == 43200) {
        FileWriter fileWriter = new FileWriter("/root/UsefulAppid.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(file.getName());
        bufferedWriter.write("\n");
        bufferedWriter.flush();
        bufferedWriter.close();
      }
    } // for end.
  }
}
