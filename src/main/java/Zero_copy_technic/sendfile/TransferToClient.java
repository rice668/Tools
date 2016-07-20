package Zero_copy_technic.sendfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class TransferToClient {

  public static void main(String[] args) throws IOException {
    TransferToClient sfc = new TransferToClient();
    sfc.testSendfile();
  }

  public void testSendfile() throws IOException {
    String host = "localhost";
    int port = 9026;
    SocketAddress sad = new InetSocketAddress(host, port);
    SocketChannel sc = SocketChannel.open();
    sc.connect(sad);
    sc.configureBlocking(true);

    String fname = "/root/Tools/src/main/java/XMl_OP_Xiaolong/idList.txt";
    long fsize = 183678375L;

    FileChannel fc = new FileInputStream(fname).getChannel();
    long start = System.currentTimeMillis();
    long curnset = 0;
    curnset = fc.transferTo(0, fsize, sc);
    System.out.println("total bytes transferred--" + curnset + " and time taken in MS--" + (System.currentTimeMillis() - start));
    //fc.close();
  }


}
