package BasicJava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 16-3-10.
 */
public class SimpleDateFormatTest {

  /**
   * The code from org.apache.hadoop.maven.plugin.versioninfo.VersionInfoMojo
   * Returns a string representing current build time.
   *
   * @return String representing current build time
   */
  private static String getBuildTime() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return dateFormat.format(new Date());
  }

  public static void main(String[] args) {
    System.out.println(SimpleDateFormatTest.getBuildTime());
  }
}
