package HomeWork.HomeWork1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        //1). 使用反射获取Student的Class对象。
        Class<?> c = Class.forName("HomeWork.HomeWork1.Student");

        //2). 获取 “公有、全参构造方法”；
        Constructor<?> declaredConstructor = c.getDeclaredConstructor(String.class, int.class);
        System.out.println("declaredConstructor = " + declaredConstructor);

        //3). 调用 “公有、全参构造方法”传入：“柳岩”,17两个参数。
        Student p1 = (Student) declaredConstructor.newInstance("柳岩", 17);

        //4). 反射获取show()方法
        Method show = c.getDeclaredMethod("show");

        //5). 调用show()方法
        show.invoke(p1);
    }
}
