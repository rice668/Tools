package BasicJava.IO;

import java.io.*;

/**
 * Java's stream based IO is built upon four abstract classes:
 *
 *  1:InputStream,
 *  2:OutputStream,
 *  3:Reader,
 *  4:Writer
 *
 * InputStream and OutputStream are designed for byte stream. Reader and Writer
 * are designed for character streams.
 */
public class StreamTest {

    static void testFileStream() throws Exception{
        FileInputStream ins = new FileInputStream(new File("C:\\Users\\mingleiz\\flatbuffer.txt"));
        byte[] bytes = new byte[ins.available()];
        ins.read(bytes);
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\mingleiz\\another.txt"));
        fos.write(bytes);
        ins.close();
        fos.close();
    }

    /**
     * For the byte-oriented streams, a buffered stream extends a filterd stream class
     * by attaching a memory buffer to the I/O streams. This buffer allow java to do
     * I/O operation on more than a byte at a time, hence increasing performance.
     *
     * Buffering I/O is a very common performance optimization.
     *
     */
    static void testBufferStream() throws Exception {
        FileInputStream ins = new FileInputStream(new File("C:\\Users\\mingleiz\\flatbuffer.txt"));
        byte[] bytes = new byte[ins.available()];
        BufferedInputStream bis = new BufferedInputStream(ins);
        int numBytesInInputStream = bis.available();
        bis.read(bytes);
        int numBytesInInputStream_ = bis.available();
//    String str = new String(bytes);
//    System.out.println(str);
        int c;
        while ((c = bis.read()) != -1) {
            System.out.print((char) c);
        }
    }

    /**
     * ByteArrayInputStream is an implementation of an input stream that uses a byte array
     * as the source.
     *
     * ByteArrayOutputStream is an implementation of an output stream that uses a byte array
     * as the destination.
     *
     * @throws Exception
     */
    static void testByteStream() throws Exception {
        String str = "gaolun is a sb";
        byte[] bytes = str.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String s = "hello, gaolun , are you a sb ?";
        byte[] bytes1 = s.getBytes();
        outputStream.write(bytes1); //
        OutputStream outputStream1 = new FileOutputStream("test.txt");
        outputStream.writeTo(outputStream1);
        outputStream.reset(); // avoid repeat write and make the number of valid bytes in the buffer to zero.
        outputStream.write('X');
        outputStream.write('Y');
        outputStream.write('Z');
        outputStream.writeTo(outputStream1);
        System.out.println(outputStream.toString());
    }

    /**
     * Show how to use DataStream
     * @throws Exception
     */
    static void testDataStream() throws Exception{
        FileOutputStream fout = new FileOutputStream("Test.dat");
        DataOutputStream dout = new DataOutputStream(fout);
        dout.writeInt(1000);
        FileInputStream fins = new FileInputStream("Test.dat");
        DataInputStream dins = new DataInputStream(fins);
        int i = dins.readInt();

    }

    /**
     * RandomAccessFile is special because it supports positioning requests -
     * that is, you can position the file pointer within the file.
     */
    static void testRandomAccessFile() throws Exception{
        FileOutputStream out = new FileOutputStream("Test.dat");
        DataOutputStream dout = new DataOutputStream(out);
        dout.write("gaolun is a big sb".getBytes());
        RandomAccessFile raf = new RandomAccessFile("Test.dat", "r");
        raf.seek(2);
        int c;
        while ((c = raf.read())!= -1) {
            System.out.print((char)c);
        }
    }

    static void testDataStreamAndRandomAccessFile() throws Exception {
        FileOutputStream out = new FileOutputStream("TestFile.dat");
        DataOutputStream dout = new DataOutputStream(out);
        long size = "HelloWorld".getBytes().length;
        dout.write("HelloWorld".getBytes());
        dout.writeInt(1000);

        RandomAccessFile file = new RandomAccessFile("TestFile.dat", "r");
        file.seek(size);
        int num = file.readInt();

    }

    public static void main(String[] args) throws Exception{
//    testArrayList();
//      testFileStream();
//        testByteStream();
//    testBufferStream();
//    testDataStream();
//    testRandomAccessFile();
        testDataStreamAndRandomAccessFile();
    }
}