package BasicJava;

public class StringBuffer_StringBuilder_String {

    public static void main(String[] args) {
        /**
         * 这样在字符串对象池里面就会产生诸如 1,12,123,23,234这样的无用的字符串，我们最终只需要使用1234就可以了
         * 所以需要StringBuffer，StringBuilder，无需拼接
         */
        String str = "1" + "2" + "3" + "4";

        /**
         * 线程安全的
         */
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        sb.append("2");
        sb.append("3");
        sb.append("4");

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