package BasicJava;

import java.lang.reflect.Field;

/**
 * String类是不可变类，为什么？真的不可变吗？
 * http://www.2cto.com/kf/201401/272974.html
 *
 */
public class StringTest_Reflect {
    public static void main(String[] args) throws Exception{
        /**
         * 打开toLowerCase方法的实现，最终返回的是一个新的字符串，所以原来的String对象是不可变的
         * return new String(result, 0, len + resultOffset);
         * 这也就是为什么像replace， substring，toLowerCase等方法都存在返回值的原因
         */
        String s = "abcDEF";
        String newS = s.toLowerCase();
        System.out.println("s = " + s + "\n"+newS);

        /**
         * private final char value[];
         * 从上文可知String的成员变量是private final 的，也就是初始化之后不可改变。
         * 那么在这几个成员中， value比较特殊，因为他是一个引用变量，而不是真正的对象。
         * value是final修饰的，也就是说final不能再指向其他数组对象，那么我能改变value指向的数组吗？
         * 比如将数组中的某个位置上的字符变为下划线“_”。 至少在我们自己写的普通代码中不能够做到，因为
         * 我们根本不能够访问到这个value引用，更不能通过这个引用去修改数组。 那么用什么方式可以访问私有成员呢？
         *  没错，用反射， 可以反射出String对象中的value属性， 进而改变通过获得的value引用改变数组的结构。下面是实例代码：
         */
        String str = "Hello World";
        System.out.println("str = " + str); //Hello World

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");
        //改变value属性的访问权限
        valueFieldOfString.setAccessible(true);
        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(str);
        //改变value所引用的数组中的第5个字符
        value[5] = '_';
        System.out.println("str = " + str);

        /**
         * 在这个过程中，s始终引用的同一个String对象，但是再反射前后，这个String对象发生了变化，
         * 也就是说，通过反射是可以修改所谓的“不可变”对象的
         */
    }
}