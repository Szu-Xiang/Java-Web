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

//动态代理
public class Test10_2 {
    public static void main(String[] args) {
        JinLian jl = new JinLian();

        //获取动态代理对象

        //被代理对象的类加载器
        ClassLoader classLoader = jl.getClass().getClassLoader();
        //被代理对象实现的接口
        Class<?>[] interfaces = jl.getClass().getInterfaces();
        //事件处理器接口实习类对象
        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //参数2：method 代理对象调用的方法对象 happy方法 --> method方法对象
                //参数3：Object[] args 代理对象调用方法传递的参数
                System.out.println("a a ");
                return null;
            }
        };

        //代理对象应使用父接口类型接收
        FindHappy fh = (FindHappy) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        //使用代理对象，调用方法
        fh.happy();
    }
}
