package demo2_获取构造方法对象;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
