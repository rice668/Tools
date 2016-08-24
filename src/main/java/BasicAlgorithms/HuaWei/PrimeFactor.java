package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/24.
 * http://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tqId=21229&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class PrimeFactor {

  public static String getResult(long ulDataInput) {
    StringBuilder str=new StringBuilder();
    int index=2;
    while(index <= ulDataInput) {
      if(ulDataInput % index == 0) {
        if(index == ulDataInput) {
          str.append(index).append(" ");
          break;
        } else {
          str.append(index).append(" ");
          ulDataInput = ulDataInput/index;
        }
      } else {
        index++;
      }
    }
    return str.toString();
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    while (sc.hasNext()) {
      long params=sc.nextLong();
      String result =getResult(params);
      System.out.println(result);
    }
  }
}
