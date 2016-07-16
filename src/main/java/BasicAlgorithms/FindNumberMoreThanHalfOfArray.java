package BasicAlgorithms;

import java.util.Arrays;
import java.util.HashMap;

public class FindNumberMoreThanHalfOfArray {
    /**
     * 方法一,先用HashMap统计每个数字出现的次数,然后再......
     * @param num
     * @return
     */
    public int majorityElement0(int[] num) {
        int result = 0;
        if (num == null)
            throw new NullPointerException();
        if(num.length == 1) {
            return num[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);
            }
        }
        // Traverse array and get every item's count.
        for (int i = 0 ; i < num.length ; i++) {
            int value = map.get(num[i]);
            if (value > num.length / 2) {
                result = num[i];
            }
        }
        return result;
    }
    /**
     * 此方法妙哉啊,如果数组中出现的数字超过了数组中的一半的话,那么中间值一定是我们需要的数字
     * 先把数组进行一个排序就好，前提是这个数字确实存在
     * @param num
     * @return
     */
    public int majorityElement(int[] num) {
        Arrays.sort(num);
        return num[num.length/2];
    }
    public static void main(String[] args) {
        FindNumberMoreThanHalfOfArray f = new FindNumberMoreThanHalfOfArray();
        int[] arr = {1,2,2,4,4,4,4,4,4,4,2};
        System.out.println(f.majorityElement(arr));
        System.out.println(f.majorityElement0(arr));
    }
}