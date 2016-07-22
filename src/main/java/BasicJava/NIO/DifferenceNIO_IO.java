package BasicJava.NIO;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by root on 16-7-22.
 */
public class DifferenceNIO_IO {
  public static void main(String[] args) throws Exception {
    RandomAccessFile aFile = new
            RandomAccessFile("/root/Tools/src/main/java/BasicJava/NIO/DifferenceFromIO.txt", "rw");
    FileChannel fileChannel = aFile.getChannel();
    ByteBuffer buf = ByteBuffer.allocate(1024);
    int bytesRead = fileChannel.read(buf);
    System.out.println(bytesRead);
    while(bytesRead != -1)
    {
      buf.flip();
      while(buf.hasRemaining())
      {
        System.out.print((char)buf.get());
      }

      buf.compact();
      bytesRead = fileChannel.read(buf);
    }
  }
}
