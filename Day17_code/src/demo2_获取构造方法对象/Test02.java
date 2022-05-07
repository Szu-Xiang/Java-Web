package demo2_获取构造方法对象;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
            通过反射获取类中的构造方法对象
                getConstructors():获取所有public修饰的构造方法
                getDeclaredConstructors:获取所有的构造方法
                getConstructor(Class.. params):根据参数类型获取指定public修饰的构造方法对象
                getDeclaredConstructor:获取指定构造方法对象
         */

        //想要反射，一定要先得到类的字节码文件对象
        Class<?> c = Class.forName("demo2_获取构造方法对象.Person");

        //1.获取所有public修饰的构造方法
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }

        //2.获取所有构造方法
        System.out.println("--------------------------------");
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }

        //3.获取指定的public修饰的构造方法,看到public，想到用getConstructor
        System.out.println("--------------------------------");
        //第一个
        Constructor<?> con1 = c.getConstructor();
        System.out.println("无参构造方法 con1 = " + con1);
        //第二个
        Constructor<?> con2 = c.getConstructor(String.class);
        System.out.println("String类型构造方法 con2 = " + con2);
        //第三个
        Constructor<?> con3 = c.getConstructor(Integer.class);
        System.out.println("Integer类型构造方法 con3 = " + con3);

        //4.获取指定的构造方法[public protected 默认 private]
        System.out.println("--------------------------------");
        Constructor<?> con4 = c.getDeclaredConstructor(String.class, Integer.class);
        System.out.println("指定类型的构造方法con4 = " + con4);

        //5.使用反射技术通过Constructor对象创建类的对象
        System.out.println("--------------------------------");
        //无参构造
        Person p1 = (Person) con1.newInstance();
        p1.show();
        //String
        Person p2 = (Person) con2.newInstance("Marry");
        p2.show();
        //Integer
        Person p3 = (Person) con3.newInstance(34);
        p3.show();
        //第四个构造方法
        // 前面讲到：私有成员只能在本类中使用 不能在外部其他类中使用
        // 现在：使用反射就可以忽视这种要求  可以跳过权限检查 这样我们就可以在一个类中访问其他类中的私有成员
        con4.setAccessible(true);
        Person p4 = (Person) con4.newInstance("Harrison", 18);
        p4.show();


    }
}
