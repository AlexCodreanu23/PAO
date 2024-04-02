package task1;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        MyOptional<String> o1 = MyOptional.of(new String("asd"));
        System.out.println(o1.isPresent());
        System.out.println(o1.get());

        MyOptional<Object> o2 = MyOptional.of(java.util.List.of("1", "2"));
        System.out.println(o2.isPresent());
        System.out.println(o2.get());

        MyOptional<Serializable> o3 = MyOptional.of(null);
        System.out.println(o3.isPresent());
        System.out.println(o3.get());
    }
}