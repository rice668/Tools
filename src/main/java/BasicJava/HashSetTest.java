package BasicJava;

import java.util.HashSet;

class Employee{
    String name;
    int age;
    public Employee(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
    @Override
    public boolean equals(Object obj) {
        Employee stu = (Employee)obj;
        if (this.name == stu.name && this.age == stu.age) {
            return true;
        } else {
            return false;
        }
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Employee> set = new HashSet<Employee>();
        set.add(new Employee("zhangminglei",25));
        System.out.println(set.contains(new Employee("zhangminglei",25)));
    }
}