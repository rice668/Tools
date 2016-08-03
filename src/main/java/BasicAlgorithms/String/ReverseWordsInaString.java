package BasicAlgorithms.String;

/**
 * 输入一个英文字句,翻转句子中单词的顺序,但单词内字符的顺序不变。
 * Given an input string, reverse the string word by word. For example,
 *
 * Given s = "the sky is blue", return "blue is sky the".
 *
 */
public class ReverseWordsInaString {

    public String[] reverseStringArray(String[] arr) {
        String[] strArr = new String[arr.length];
        for (int i = 0 ; i < arr.length ; i++) {
            StringBuilder sb = new StringBuilder(arr[i]).reverse();
            String str = new String(sb);
            strArr[i] = str;
        }
        return strArr;
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        String newStr = sb.reverse().toString(); //yks eht
        String[] str1 = newStr.split(" "); // {"yks", "eth"}
        String[] str2 = reverseStringArray(str1);
        newStr = "";
        for (int i = 0; i < str2.length; i++) {
            newStr += (str2[i] + " ");
        }
        return newStr;
    }


    public static void main(String[] args) {
        ReverseWordsInaString r = new ReverseWordsInaString();
        String str = "the sky is blue";
        System.out.println(r.reverseWords(str));
    }
}