package demo4_获取属性字段;

import java.lang.reflect.Field;

public class Test04 {
    public static void main(String[] args) throws Exception {
        //1.使用反射 一定要得到类的字节码对象
        Class<?> c = Class.forName("demo4_获取属性字段.Person");

        //2.获取当前类中所有public修饰的对象
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        //3.获取当前类中所有字段对象
        System.out.println("-----------------");
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }

        //4.根据字段名称获取当前类中public修饰的指定字段对象
        System.out.println("-----------------");
        Field nameF = c.getField("name");
        System.out.println("nameF = " + nameF);

        //5.获取任意修饰符修饰的指定字段对象
        System.out.println("-----------------");
        Field ageF = c.getDeclaredField("age");
        System.out.println("ageF = " + ageF);

        //6.使用Field对象调用方法为属性赋值 或者 获取属性值
        //Person对象
        Object o = c.getDeclaredConstructor().newInstance();
        nameF.set(o, "ghx");
        //age为private，所有需要跳过权限检查
        ageF.setAccessible(true);
        ageF.set(o, 24);

        System.out.println("nameF.get(o) = " + nameF.get(o));
        System.out.println("ageF.get(o) = " + ageF.get(o));
    }
}
