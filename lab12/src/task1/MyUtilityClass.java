package task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

public class MyUtilityClass {

    public static <T> void printCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        System.out.println(collection);
    }
    public static <T, R> R aggregate(Collection<T> collection, R initial, BiFunction<R, T, R> accumulator) {
        if (collection == null || accumulator == null) {
            throw new IllegalArgumentException("Collection and accumulator cannot be null");
        }
        R result = initial;
        for (T element : collection) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    public static <T> List<T> duplicateCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        List<T> duplicated = new ArrayList<>();
        for (T element : collection) {
            duplicated.add(element);
            duplicated.add(element);
        }
        return duplicated;
    }
}
