package demo10_代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test10_4 {
    public static void main(String[] args) {
        /*
            需求：删除List集合中所有相同的元素
            分析：直接使用remove方法只能删除第一个
            解决：
                1.加循环
                2.使用装饰者设计模式  对Collection接口中的remove方法进行增强，其他不需要增强
                3.使用动态代理实现

         */

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bac");
        list.add("abc");
        list.add("cba");
        list.add("abc");
        list.add("abc");

//        System.out.println("删除之前："+list);
//        //list原有的方法无法实现
//        list.remove("abc");
//        System.out.println("删除之后："+list);

        //使用动态代理实现：对Collection接口中的remove方法进行增强，其他不需要增强
        /*
            动态代理实现步骤：
                1.定义一个父接口           eg：Collection
                2.提供一个被代理对象        eg：List<String> list = new ArrayList<>();
                3.使用Proxy.newProxyInstance方法动态得到被代理对象的代理对象 使用父接口类型接收
                4.在InvokeHandler接口中的invoke方法中 对要进行增强的方法进行增强，不需要进行增强的方法调用被代理对象的原有实现即可
         */

        Collection proxy = (Collection) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                //在InvokeHandler接口中的invoke方法中 对要进行增强的方法进行增强，不需要进行增强的方法调用被代理对象的原有实现即可
                if("remove".equals(method.getName())){
                    boolean flag = false;
                    //1.获取集合的迭代器对象
                    Iterator<String> itor = list.iterator();
                    //2.对迭代器进行遍历 遍历时有符合条件的元素就进行删除
                    while(itor.hasNext()){
                        //获取元素
                        String e = itor.next();
                        //args[0]:  使用代理对象调用方法 会将方法的参数封装到Object类型数组args中  得到第一个参数就是args[0] 得到第二个参数就是args[1]
                        if(e.equals(args[0])){     //"abc" "bac"   args=["abc"]
                            itor.remove();
                            flag = true;
                        }
                    }
                    return flag;
                }else{
                    res = method.invoke(list,args);  //list.toString()
                }
                return res;
            }
        });

        proxy.remove("abc");
        System.out.println("删除之后："+list);

        System.out.println(proxy.remove("bac"));
        System.out.println("删除之后："+list);

        System.out.println(proxy.remove("aaa"));
        System.out.println("删除之后："+list);



    }
}
