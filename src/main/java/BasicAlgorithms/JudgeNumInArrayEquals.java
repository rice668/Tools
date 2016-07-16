package BasicAlgorithms;
import java.util.HashMap;
import java.util.Map;

public class JudgeNumInArrayEquals {

    /**
     * 判断一个数组里面的数字是否都相等
     *  0^a = a
     *  把这些数字放入到HashMap里面,统计出现的次数
     * @param arr
     * @return
     */
    public boolean judge(int[] arr){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        System.out.println(map);
        int count = map.get(arr[0]);
        if(count == arr.length)
            return true;
        else
            return false;
    }
    /**
     * 选数组里面的第一个元素做为标杆,然后把后面的数字依次和刚刚选的数字进行比较
     * @param arr
     * @return
     */
    public boolean judge1(int[] arr){
        int first = arr[0];
        int i = 0;
        for(;i<arr.length;i++){
            if(first == arr[i])
                continue;
            else
                break;
        }
        if(i == arr.length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = {5,5,5,5,5,5,1};
        System.out.println(new JudgeNumInArrayEquals().judge(arr));
        System.out.println(new JudgeNumInArrayEquals().judge1(arr));
    }
}