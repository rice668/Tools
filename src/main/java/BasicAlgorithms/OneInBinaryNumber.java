package BasicAlgorithms;


public class OneInBinaryNumber {

    /**
     * http://coderlxl201209164551.iteye.com/blog/1705576
     * 对于这个函数，如果传入的参数是一个负数，右移一位并不是
     * 简单的把0x80000000变为0x40000000，而是0xC0000000，
     * 因为移位前是个负数，移位后还要是一个负数。这样会产生死循环。
     * @param n
     * @return
     */
    public int numberOf1(int n){
        int count = 0;
        while(n!=0){
            if((n&1) != 0)
                count ++;
            n>>=1;
        }
        return count;
    }

    /**
     * 正数、负数都行
     * @param n
     * @return
     */
    public int numberOf1_(int n){
        int count = 0;
        int flag = 1;
        int i = 0;
        while(i<32){//得循环32次
            if((n & flag) !=0 )
                count++;
            flag = flag<<1;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {

        OneInBinaryNumber o = new OneInBinaryNumber();
        System.out.println(o.numberOf1_(0x80000000));
        System.out.println(o.numberOf1_(5));//00000000000000000...101
    }
}