package BasicAlgorithms.Bit;

/**
 * Created by mingleizhang on 2016/8/24.
 */
public class IntToByteArray {

  public static byte[] intToByteArray(int a)
  {
    byte[] ret = new byte[4];
    ret[3] = (byte) (a & 0xFF);
    ret[2] = (byte) ((a >> 8) & 0xFF);
    ret[1] = (byte) ((a >> 16) & 0xFF);
    ret[0] = (byte) ((a >> 24) & 0xFF);
    return ret;
  }
  public static void main(String[] args) {
    Integer a = 10;
    intToByteArray(a);
  }
}
