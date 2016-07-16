package BasicJava;

/**
 * Created by root on 16-2-17.
 */

/**
 * static val is shared
 */

class Person {
    public static int age;
    public void setAge(int age_) {
        age = age_;
    }
}
public class TestStaticVal {
    public static void main(String[] args) {
        Person tom = new Person();
        Person jack = new Person();
        tom.setAge(10);
        jack.setAge(20);
        tom.setAge(30);
        System.out.println(tom.age);
        System.out.println(jack.age);
    }
}