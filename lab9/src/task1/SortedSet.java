package task1;

import java.util.Comparator;
import java.util.Set;

public interface SortedSet<T> extends Set<T> {
    Comparator<? super T> getComparator();
    boolean add(T element);
    T first();
    T last();
    SortedSet<T> subSet(T fromElement, T toElement);
    SortedSet<T> headSet(T toElement);
    SortedSet<T> tailSet(T fromElement);


}