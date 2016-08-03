package BasicAlgorithms.Array;

import java.util.Arrays;
/**
 * 编程之美,快速寻找满足条件的2个数
 * 点评：面试中很多题目都是给定一个数组,要求返回2个下标的(比如找2个元素,或者找一个子数组)
 * 而相应比较高效的解法则是先排序,然后在一个循环体里用2个变量(指针)进行反向的遍历
 *
 */
public class FindTwoNumberEqualsOneNumber {

    public boolean find(int[] arr,int value) {
        if(arr == null)
            throw new NullPointerException(); // 这个地方到底怎么做得根据你的需要而定，并不一定是要返回一个NPE
        //要先排序
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        for( ; i < j ; ) {
            if( arr[i]+arr[j] == value ) {
                return true;
            } else if ( arr[i]+arr[j]<value ){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindTwoNumberEqualsOneNumber f = new FindTwoNumberEqualsOneNumber();
        int[] arr = {5,6,1,4,7,9,9,8};
        int value = 18;
        System.out.println(f.find(arr, value));
        System.out.println("final hello ");
    }
}