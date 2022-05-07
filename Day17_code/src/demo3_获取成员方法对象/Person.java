package demo3_获取成员方法对象;

public class Person {
    private String name;
    private Integer age;

    //构造方法
    public Person() {
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //成员方法
    public void show(){
        System.out.println("name:"+name+" age:"+age);
    }

    public void show1(String address) {
        System.out.println("name:"+name+" age:"+age + "address:" + address);
    }

    public String show2(int num) {
        System.out.println("name:"+name+" age:"+age + "num:" + num);
        return "haha";
    }

    private void show3(String address, int num) {
        System.out.println("address" + address + " " + "num:" + num);
    }

    public static void show4() {
        System.out.println("静态方法show2");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
