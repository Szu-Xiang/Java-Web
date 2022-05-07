package demo5_注解定义;

public @interface MyAnnotation {
    /*
        概念：注解本质是接口，只有属性，没有方法

        格式：
            public @interface MyAnnotation {
                属性类型 属性名

            }
        属性类型：
            基本类型
            String类型
            枚举类型
            注解类型
            Class类型
            一维数组类型

     */
    int num();
    String name();
    Gender gender();
    Class c();
    String[] arr();
}
