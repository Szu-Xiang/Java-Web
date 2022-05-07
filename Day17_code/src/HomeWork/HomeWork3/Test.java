package HomeWork.HomeWork3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestDemo t = new TestDemo();
        // 扫描所有的方法对象，看方法上是否有注解，有就触发它。
        Class clazz = TestDemo.class;
        // 获取全部的方法
        Method[] methods = clazz.getDeclaredMethods();
        // 遍历全部方法
        for(Method mt : methods){
            // 判断这个方法是否有MyTest注解，有就触发它执行
            if(mt.isAnnotationPresent(MyTest.class)){
                // 触发这个方法执行！
                mt.invoke(t);
            }
        }
    }
}
