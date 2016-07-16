package scala.util;

import java.io.File;

/**
 * Created by root on 16-3-14.
 */

/**
 * Attention that the two key words "public" is very important.
 */
public class FileUtil {
    /**
     * delete Dir and the files under this Dir.
     * @param dir
     * @return
     */
   public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
