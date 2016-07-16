package BasicJava.NIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Reference:
 * http://javapapers.com/java/java-nio-channel/
 */
public class ChannelExample {
    public static void main(String[] args) throws Exception{
        RandomAccessFile file = new RandomAccessFile("/root/rebuilt.sh", "r");
        FileChannel fileChannel = file.getChannel(); // if you use File, you can not get a FileChannel

        // Once a file channel is opened, obtain the size of the file is called size(), measured in bytes.
        long sizeOfFile = fileChannel.size();
        ByteBuffer byteBuffer = ByteBuffer.allocate(330);
        /**
         * fileChannel.read(byteBuffer)
         */
        while (fileChannel.read(byteBuffer) > 0) {
            //
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            } // while end, that is mean, position is equals to limit.
            byteBuffer.clear(); //
        }
        file.close();
    }
}