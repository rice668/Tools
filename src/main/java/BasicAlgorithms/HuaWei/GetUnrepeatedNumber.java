package BasicAlgorithms.HuaWei;
import java.util.Scanner;
/**
 * Created by mingleizhang on 2016/8/25.
 *
 * HashSet,TreeSet和LinkedHashSet的区别
 * http://www.nowcoder.com/practice/253986e66d114d378ae8de2e6c4577c1?tpId=37&tqId=21232&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 */
import java.util.LinkedHashSet;
import java.util.Set;

public class GetUnrepeatedNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()) {
      char[] nums = sc.nextLine().toCharArray();
      Set<Character> st = new LinkedHashSet<Character>();
      for (int i = nums.length -1; i >= 0; i--) {
        st.add(nums[i]);
      }
      String result = "";
      for (Character c : st) {
        result += c + "";
      }
      System.out.println(result);
    }
  }
}