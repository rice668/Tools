package BasicAlgorithms.String;

import java.util.Stack;

/**
 *
 *  1：首尾交换
 *	2：递归输出
 *	3：通过栈
 *	4：通过堆，大根堆可以实现字符串逆序（优先级）
 *	5：提供好的API，比如Java里面的StringBuilder或者StringBuffer
 *
 * @author Administrator
 *
 */
public class ReverseString {

    public String reverse(String str) {
        if(str == null)
            throw new NullPointerException();
        char[] ch;
        ch = str.toCharArray();
        for (int i = 0, j = ch.length - 1; i <= j; i++, j--) {
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
        }
        str = new String(ch);
        return str;
    }
    public String reverseStringByStack(String str){
        Stack<Character> stack = new Stack<Character>();
        char[] ch = str.toCharArray();
        for(int i = 0;i < ch.length ;i++)
            stack.push(ch[i]);
        for(int i = 0;i<ch.length;i++)
            ch[i] = stack.pop();
        String newStr = new String(ch);
        return newStr;
    }
    /**
     * 递归的输出字符串
     * @param str
     */
    public String reverseStringByRecur(String str) {
        if (str == null)
            throw new NullPointerException();
        //递归出口
        if (str.length() != 0) {
            char[] ch = str.toCharArray();
            char[] newCh = new char[ch.length - 1];
            for (int i = 0; i < ch.length - 1; i++)
                newCh[i] = ch[i + 1];
            String newStr = new String(newCh);
            reverseStringByRecur(newStr);
            char[] another_ch = new char[ch.length];
            for(int i = ch.length - 1;i >= 0;i--)
                another_ch[ch.length-1-i] = ch[i];
            String anotherNewStr = new String(another_ch);
            return anotherNewStr;
        }return null;
    }

    public static void main(String[] args) {
        /**
         * 当然在构造字符串的时候用StringBuilder
         */
        ReverseString rs = new ReverseString();
        String str1 = "abcd";
        System.out.println(rs.reverse(str1));

    }

}
