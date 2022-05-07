package demo10_代理模式;

public class WangPo implements FindHappy{
    private JinLian jinLian;

    public WangPo(JinLian jinLian) {
        this.jinLian = jinLian;
    }

    @Override
    public void happy() {
        System.out.println("准备房间");
        System.out.println("准备工具");
        System.out.println("叫金莲和门庆");
        jinLian.happy();
        System.out.println("打扫战场");
    }
}
