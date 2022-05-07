package HomeWork.HomeWork3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD})// 只能注解方法了
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}
