package HomeWork.HomeWork2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add("大明");
        names.add("小明");
        names.add("二明");

        names.stream().forEach(System.out::println);
    }
}
