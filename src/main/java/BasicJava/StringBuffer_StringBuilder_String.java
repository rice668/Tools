package BasicJava;

/**
 * 这2个网页解释的非常好
 * http://www.cnblogs.com/Fskjb/archive/2010/04/19/1715176.html
 * http://blog.csdn.net/rmn190/article/details/1492013#comments
 *
 * String 字符串常量
 * StringBuffer 字符串变量（线程安全）
 * StringBuilder 字符串变量（非线程安全）
 *
 *
 */
public class StringBuffer_StringBuilder_String {

    void testPerformance() {
        /**
         *
         5266 millis has elapsed when used String.
         375 millis has elapsed when used StringBuffer.
         281 millis has elapsed when used StringBuilder.
         从上面的结果来看，这三个类在单线程程序中的性能差别一目了然，采用String对象时，即使运行次数仅是采用其他对象的1/100，
         其执行时间仍然比其他对象高出25倍以上；而采用StringBuffer对象和采用StringBuilder对象的差别也比较明显，前者是后者
         的1.5倍左右。由此可见，如果我们的程序是在单线程下运行，或者是不必考虑到线程同步问题，我们应该优先使用StringBuilder
         类；当然，如果要保证线程安全，自然非StringBuffer莫属了。
         */
    }

    public static void main(String[] args) {
        /**
         * 这样在字符串对象池里面就会产生诸如 1,12,123,23,234这样的无用的字符串，我们最终只需要使用1234就可以了
         * 所以需要StringBuffer，StringBuilder，无需拼接
         */
        String str = "1" + "2" + "3" + "4";

        /**
         * 线程安全的，也就是说多个线程去访问这段代码，不会产生不一致性, StringBuffer里面许多方法都有
         * synchronized关键字，也就是说多个进程同时访问这个方法时会同步的去访问
         * public synchronized StringBuffer append(?)
         */
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        sb.append("2");
        sb.append("3");
        sb.append("4");
        System.out.println(sb.toString()); //把StringBuffer对象转换成String对象

        /**
         * 线程不安全的，多个线程(进程)去访问这段代码可能会导致拼接错误，进而导致错误
         * public StringBuilder append
         */
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("zhang");
        sBuilder.append("ming");
        sBuilder.append("lei");
        System.out.println(sBuilder.toString());

    }
}