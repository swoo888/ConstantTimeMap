package LimitedMap;

public interface LimitedMap<K extends CharSequence, V> {
    V get(K key);

    V put(K key, V value);
}
