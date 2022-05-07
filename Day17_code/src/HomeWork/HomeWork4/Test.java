package HomeWork.HomeWork4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
    对Collection接口进行代理，以前的remove(Object obj)方法是删除集合中第一次出现的元素
    (比如集合中有多个“abc”,调用remove(“abc”)后只会删除一个元素)。

    代理后，要求在调用remove(Object obj)方法后，能够删除集合中所有匹配的元素。【动态代理】

 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bac");
        list.add("abc");
        list.add("cba");
        list.add("abc");
        list.add("abc");
        list.add("ccc");


        List proxy = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 执行一下代理对象调用的方法
                Object res = method.invoke(list, args);

                // remove方法增强的代码
                // 如果代理对象调用的方法是删除方法,就删除集合中所有元素
                if (method.getName().equals("remove")) {
                    // 判断集合中的元素是否是要删除的元素
                    list.removeIf(e -> e.equals(args[0]));
                }

               /* if (method.getName().equals("set")){
                    throw new Exception("不允许修改");
                }*/
                if (method.getName().equals("set")){
                    System.out.println("set 哈哈哈哈");// 假设这么增强set方法
                }

                return res;
            }
        });

        boolean res1 = proxy.remove("abc");
        System.out.println("res1 = " + res1);
        Object res2 = proxy.set(1, "bacdf");
        System.out.println("res2 = " + res2);//返回之前原位置的值

        System.out.println("删除之后：" + list);
    }
}
