package BasicAlgorithms.Bit;

/**
 * 判断机器的位数，一个整型变量
 *
 * @author Administrator
 */
public class IntegerNumberNoSizeof {
  public static void main(String[] args) {
    int a = 1;
    int count = 0;
    while (a >= 0) {
      a <<= 1;
      count++;
    }
    System.out.println(count+1);
  }
}