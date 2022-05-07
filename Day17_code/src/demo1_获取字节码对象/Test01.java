package demo1_获取字节码对象;

public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException {
        /*
        获取一个类的字节码对象有三种方式：
        1. 对象.getclass()
        2. Class.forName("全限定类名)   推荐使用第二种
        3. 类名.class
     */
        Person person = new Person();
        //方式一
        Class c1 = person.getClass();
        //方式二
        Class c2 = Class.forName("demo1_获取字节码对象.Person");
        //方式三
        Class c3 = Person.class;

        System.out.println("c1 == " + c1);
        System.out.println(c1.getName());//获取类全名
        System.out.println(c1.getSimpleName());//获取类名。

    }
}
