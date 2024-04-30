package task1;
import java.util.*;

public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {
    private Comparator<? super T> comparator;
    public SortedListSet() {
        this(null);
    }
    public SortedListSet(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator<? super T> getComparator() {
        return comparator;
    }

    @Override
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            T current = get(i);
            if (compare(element, current) < 0) {
                super.add(i, element);
                return true;
            }
        }
        super.add(element);
        return true;
    }

    private int compare(T a, T b) {
        if (comparator == null) {
            return a.compareTo(b);
        } else {
            return comparator.compare(a, b);
        }
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return getFirst();
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return getLast();
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        SortedListSet<T> subset = new SortedListSet<T>(comparator);
        for (T element : this) {
            if (compare(element, fromElement) >= 0 && compare(element, toElement) < 0) {
                subset.add(element);
            }
        }
        return subset;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        SortedListSet<T> headset = new SortedListSet<T>(comparator);
        for (T element : this) {
            if (compare(element, toElement) < 0) {
                headset.add(element);
            }
        }
        return headset;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        SortedListSet<T> tailset = new SortedListSet<T>(comparator);
        for (T element : this) {
            if (compare(element, fromElement) >= 0) {
                tailset.add(element);
            }
        }
        return tailset;
    }
}
