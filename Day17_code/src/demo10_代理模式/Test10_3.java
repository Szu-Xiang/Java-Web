package demo10_代理模式;

/*
    动态代理使用步骤
        1.提供一个父接口       FindHappy
        2.提供一个被代理对象    jl
        3.使用Proxy.newProxyInstance() 动态生成一个代理对象的对象
        4.在InvocationHandler的invoke方法中，对要增强的部分增强，无需增强则保留原有方法
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test10_3 {
    public static void main(String[] args) {
        JinLian jl = new JinLian();

        //使用JDK生成的代理对象用父接口进行接收
        FindHappy proxy = (FindHappy) Proxy.newProxyInstance(jl.getClass().getClassLoader(), jl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                if (method.getName().equals("happy")) {
                    System.out.println("准备房间");
                    jl.happy();
                    System.out.println("打扫房间");
                } else {
                    res = method.invoke(jl);
                }
                return res;
            }
        });

        proxy.happy();

    }
}
