package BasicJava;

/**
 * 不管是对象数组还是基本类型的数组都扩展于Object类
 * equals方法用于检测一个对象是否等于另外一个对象
 * hashCode是由对象导出的一个整型值
 * hashCode方法定义在Object类中,因此每个对象都有一个默认的散列码，其值为对象的存储地址
 *
 * @author Administrator
 *
 */
public class equals_hashcode {
    public static void main(String[] args) {
        Student s1 = new Student("zhangminglei",24,1235678);
        Student s2 = new Student("zhangminglei",25,1235678);
        System.out.println(s1 == s2);
        System.out.println(s1.hashCode() +"\n"+s2.hashCode());
        System.out.println(s1.toString()+"\n"+s2);
        if (s1.equals(s2))
            System.out.println("==");
        else
            System.out.println("!=");

        String s = "OK";
        String t = new String(s);
        System.out.println(s.hashCode() +"\n"+ t.hashCode());

        StringBuilder sb = new StringBuilder(s);
        StringBuilder tb = new StringBuilder(t);
        System.out.println(sb.hashCode() +"\n"+ tb.hashCode());

    }
}
class Student {
    String name;
    int age;
    int studentNumber;
    public Student(String name, int age,int studentNumber) {
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
    }
    /**
     * 对象值的字符串表示
     * 随处可见toString方法的主要原因是只要对象与一个操作符+连接起来，Java编译就会自动的调用
     * toString，以便获得这个对象的字符串描述
     * return "姓名是:" +name.toString() +"  年龄是:"+Integer.valueOf(age).toString();
     */
    @Override
    public String toString() {
        return "Name: " +name +"age :"+age;
    }

    /**
     * 如果重新定义了equals方法，就必须重新定义hashCode方法，以便用户可以将对象插入到散列表中
     * 为什么呢？因为如果2个对象相等，那么就是同一个对象，如果插入到不同的散列表中会造成资源浪费
     */
    @Override
    public boolean equals(Object obj) {
        Student stu = (Student) obj;
        // String也需要用equals判断
        if (stu.name.equals(this.name) && stu.studentNumber == this.studentNumber)
            return true;
        return false;
    }
    /**
     * 因为equals比较的是姓名和学号2个字段，所以hashCode只散列了学生的姓名和学号2个字段
     */
    @Override
    public int hashCode() {
        return name.hashCode() + Integer.valueOf(studentNumber).hashCode();
    }

}