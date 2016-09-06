package BasicAlgorithms.LeeCode;

import java.util.HashSet;

public class RandomNumberWithNoRepeated {
    /**
     * 产生1 ~ 10个没有重复的10个随机数
     * 利用HashSet的唯一性来产生,或者使用HashMap里的key的唯一性来产生也可以
     *
     * @return
     */
    public HashSet<Integer> generate10() {
        HashSet<Integer> set = new HashSet<Integer>();
        while (set.size() != 10) {
            int numbers = (int) (Math.random() * 11);
            if(numbers == 0) {
                continue;
            } else {
                set.add(numbers);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        RandomNumberWithNoRepeated g = new RandomNumberWithNoRepeated();
        HashSet<Integer> set = g.generate10();
        System.out.println(set);
    }
}