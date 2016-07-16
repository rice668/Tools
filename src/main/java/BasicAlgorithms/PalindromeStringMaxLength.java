package BasicAlgorithms;

public class PalindromeStringMaxLength {
    public String reverse(String str) {
        char[] ch = str.toCharArray();
        for(int i = 0,j = ch.length-1;i<=j;i++,j--){
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
        }
        return new String(ch);
    }
    public int maxLength(String str){
        if (str == null)
            throw new NullPointerException("Pass Null Value"); // According to your business
        int length = 0;
        char[] newCh;
        if(str.length()>0)
        {
            char[] ch = str.toCharArray();
            String temp = ""; //Note do not write : String temp = null
            for(int i = 0 ; i < ch.length ; i++) {
                temp = temp + ch[i];
                if(reverse(temp).equals(temp)) {
                    length = temp.length();
                }
            }
            newCh = new char[ch.length-1];
            for(int i = 0 ; i < newCh.length ; i++) {
                newCh[i] = ch[i+1];
            }
            int a = maxLength(new String(newCh));
            if(a > length) {
                return a;
            } else {
                return length;
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        PalindromeStringMaxLength s = new PalindromeStringMaxLength();
        System.out.println(s.maxLength("levellevael"));
        System.out.println(s.maxLength(null));

    }
}