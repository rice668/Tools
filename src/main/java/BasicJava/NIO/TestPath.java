package BasicJava.NIO;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by root on 16-2-17.
 */

public class TestPath {
  public static void main(String[] args) {
    FileSystem fileSystem = FileSystems.getDefault();
    Path hostsFile = fileSystem.getPath("C:\\Users\\mingleiz\\flatbuffer.txt");
    Path path = fileSystem.getPath("C:\\Users\\mingleiz");

  }
}