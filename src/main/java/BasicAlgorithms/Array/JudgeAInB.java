package BasicAlgorithms.Array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输出数组a里不在数组b中出现的元素
 * 遍历a中的每一个元素，去b数组中查看，如果b中没有的话，则输出
 *
 */
public class JudgeAInB {
    /**
     * 二分查找法
     * @param arr 数组
     * @param num 数值
     * @return 找到则返回true,否则返回false
     */
    static boolean binarySearch(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high)
        {
            int middle = (low + high) >>> 1;
            if (arr[middle] == num)
            {
                return true;
            }
            else if (arr[middle] > num)
            {
                high = middle - 1;
            }else
                low = middle + 1;
        }
        return false;
    }
    /**
     * 注意：a是无序，b是有序
     *
     * 扩展：对2个有序的数组，查找A数组的元素是否在 B数组中出现有没更好的算法？
     * 答：都有序了，就不需要折半这么麻烦了。可以往归并排序方面去想，见算法导论
     *
     * 突然灵机一动，想起归并排序的算法。就说， 是不是像归并数组那样，直接在B中定位出A的位置，
     * 这样就可以在O(m+n)内实现。他比较满意，说：“是啊，都有序了，你还折半这么麻烦啊？”
     * @param args
     */
    public static void main(String[] args) {
        int[] a = { 1, 3, 0, 19, 4, 2 ,111};
        int[] b = { 10, 19,1,2, 3, 4, 5 };
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (!binarySearch(b, a[i]))
                list.add(a[i]);
        }
        for (int i : list)
            System.out.print(i + " ");
    }

}