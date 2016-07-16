package BasicJava;

public class StringToInt {
    /**
     * 标治位,定义一个静态的全局变量判断是否遇到了非法输入
     * 如果v为0，则为合法输入，v为$，则为非法输入
     */
    static char v = '0';
    public int stringToInt(String str){
        if(str == null)
            throw new NullPointerException();
        if(str == "")
            v = '$';
        long a = 0;
        int count = 1;
        char[] ch = str.toCharArray();
        for(int i = ch.length-1;i>=0;i--)
        {
            if((ch[i] < '0' || ch[i] >'9'))
            {
                v = '$';
                return 0;
            }
            a = a + (ch[i] - '0') * count;
            count *= 10;
            if(a>Integer.MAX_VALUE || a<Integer.MIN_VALUE){
                v = '%';
                return 0;
            }
        }
        return (int)a;
    }

    public static void main(String[] args) {
        String str1 = "213232003";
        String str2 = "";
        String str3 = "8988)88";
        String str4 = "12122121234567876543";
        System.out.println(new StringToInt().stringToInt(str1)+",v = "+ StringToInt.v);
        System.out.println(new StringToInt().stringToInt(str2)+",v = "+ StringToInt.v);
        System.out.println(new StringToInt().stringToInt(str3)+",v = "+ StringToInt.v);
        System.out.println(new StringToInt().stringToInt(str4)+",v = "+ StringToInt.v);
    }
}