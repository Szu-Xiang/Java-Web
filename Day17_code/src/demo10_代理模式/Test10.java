package demo10_代理模式;

public class Test10 {
    public static void main(String[] args) {
        //创建被代理对象
        JinLian jinLian = new JinLian();
        //创建代理对象
        WangPo wangPo = new WangPo(jinLian);
        //调用方法
        wangPo.happy();
    }
}
