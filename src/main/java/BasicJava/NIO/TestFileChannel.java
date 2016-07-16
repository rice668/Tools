package BasicJava.NIO;

/**
 * Created by root on 16-2-17.
 */
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/**
 * Created by mingleiz on 10/24/2015.
 */
public class TestFileChannel {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("/root/rebuilt.sh");
        //  A channel for reading, writing, mapping, and manipulating a file.
        FileChannel fileChannel = fis.getChannel();
        long sizeFile = fileChannel.size(); // the size of file
        System.out.print(sizeFile);
    }
}