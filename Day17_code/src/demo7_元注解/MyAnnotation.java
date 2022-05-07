package demo7_元注解;

import java.lang.annotation.*;

/**
 * 定义注解的注解，若无元注解，则注解可以修饰在任意位置
 * @Target (ElementType.METHOD)：设置注解可以使用在什么位置
 *          ElementType
 *
 * @Retention(RetentionPolicy.CLASS)
 */

@Target(ElementType.METHOD)//注解只能在方法中使用
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {

}

