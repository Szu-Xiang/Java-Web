package demo3_获取成员方法对象;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            获取字节码对象中的成员方法对象：
                Method getMethod(String name,Class... parameterTypes)：获取当前类及其父类中public修饰的指定方法
                Method getDeclaredMethod(String name,Class... parameterTypes)：获取当前类中任意修饰符修饰的指定方法
                Method[] getMethods()：获取当前类及其父类中public修饰的所有方法
                Method[] getDeclaredMethods()：获取当前类中的所有方法

            方法执行：
               Object invoke(Object obj, Object... args)：由Method对象调用
                    参数1：Object obj 调用这个方法执行的对象
                    参数2：Object... args 要执行方法的参数
                    返回值类型：如果执行的方法返回值类型是void 则返回null  如果是其他类型，就返回对应类型的返回值
         */
        //使用反射，得到字节码对象
        Class c = Class.forName("demo3_获取成员方法对象.Person");

        //1.获取当前类及其父类中public修饰的指定方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        System.out.println("-------------------------");

        //2.获取当前类中任意修饰符修饰的指定方法
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }

        
    }
}
