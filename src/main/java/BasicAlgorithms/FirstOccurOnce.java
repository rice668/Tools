package BasicAlgorithms;

import java.util.HashMap;

/**
 * Created by hash-X on 2016/1/3.
 */
public class FirstOccurOnce {

    public static char firstOccurOnceByHashMap(String str) {
        if (str == null)
            throw new NullPointerException();
        char[] ch = str.toCharArray();
        HashMap hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < ch.length; i++) {
            if (!hashMap.containsKey(ch[i])) {
                hashMap.put(ch[i], 1);
            } else {
                Integer integer = (Integer) hashMap.get(ch[i]);
                hashMap.put(ch[i], ++integer);
            }
        }
        for (int i = 0; i < ch.length; i++) {
            if ((Integer)hashMap.get(ch[i]) == 1) {
                return ch[i];
            }
        }
        return '%';
    }

    public static void main(String[] args) {
        System.out.println(FirstOccurOnce.firstOccurOnceByHashMap("abaccdeff"));
    }
}