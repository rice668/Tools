package BasicJava;

public class StringPool {

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "123";

        /**
         * Java会在字符串对象池创建一个值为4的字符串对象,然后会和123进行拼接,形成1234
         * 最后在字符串对象池里面存在3个字符串,如果池里面的东西长时间没有用，会被回收的
         * "123"，"4"，"1234"
         *
         * 字符串对象池的目的是避免重复创建的一种系统开销，是对系统效率提升的一种体现。这是字符串
         * 对象池的主要作用， 线程池的道理也是一样的，避免重复的系统开销。
         */
        String s = str1 + "4";
    }
}