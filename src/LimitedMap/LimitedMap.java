package LimitedMap;

public interface LimitedMap<K extends String, V extends Object> {
    V get(K key);

    V put(K key, V value);
}
