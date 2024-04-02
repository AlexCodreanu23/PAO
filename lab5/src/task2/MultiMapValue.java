package task2;
import java.util.*;

public class MultiMapValue<K, V> {

    private final HashMap<K, ArrayList<V>> map;

    public MultiMapValue() {
        this.map = new HashMap<>();
    }

    public void add(K key, V value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public void addAll(K key, List<V> values) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).addAll(values);
    }

    public void addAll(MultiMapValue<K, V> map2) {
        for (K key : map2.map.keySet()) {
            addAll(key, map2.getValues(key));
        }
    }

    public V getFirst(K key) {
        List<V> values = map.get(key);
        return values != null && !values.isEmpty() ? values.getFirst() : null;
    }

    public List<V> getValues(K key) {
        return map.getOrDefault(key, new ArrayList<>());
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public List<V> remove(K key) {
        return map.remove(key);
    }

    public int size() {
        int totalSize = 0;
        for (List<V> values : map.values()) {
            totalSize += values.size();
        }
        return totalSize;
    }
}
