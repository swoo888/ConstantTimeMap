package LimitedMap;

public class ConstantAccessTimeMap<K extends CharSequence, V> implements LimitedMap<K, V> {
    private final int CharMin = 32; // Space
    private final int CharMax = 126; // tilda, last char


    private V value;
    private ConstantAccessTimeMap<K, V>[] itemsTable;

    public ConstantAccessTimeMap() {
        final int NumChars = CharMax - CharMin + 1;
        this.itemsTable = new ConstantAccessTimeMap[NumChars];
        this.value = null;
    }

    @Override
    public V get(K key) {
        checkKey(key);
        ConstantAccessTimeMap<K, V> item = this;

        for (int i=0; i<key.length(); i++) {
            int idx = getCharIndex(key.charAt(i));
            ConstantAccessTimeMap<K, V> nextItem = item.itemsTable[idx];
            if (nextItem == null) {
                return null;
            }
            item = nextItem;
        }
        return item.value;
    }

    @Override
    public V put(K key, V value) {
        checkKey(key);
        ConstantAccessTimeMap<K, V> item = this;

        for (int i=0; i<key.length(); i++) {
            int idx = getCharIndex(key.charAt(i));
            ConstantAccessTimeMap<K, V> nextItem = item.itemsTable[idx];
            if (nextItem == null) {
                nextItem = new ConstantAccessTimeMap<>();
                item.itemsTable[idx] = nextItem;
            }
            item = nextItem;
        }
        V oldValue = item.value;
        item.value = value;
        return oldValue;
    }

    private void checkKey(K key) throws IllegalArgumentException {
        final int MaxKeyLen = 15;
        if (key == null || key.length() == 0 || key.length() > MaxKeyLen) {
            throw new IllegalArgumentException("Invalid key");
        }
        if (key.chars().anyMatch(i-> i< CharMin || i > CharMax)){
            throw new IllegalArgumentException("Key contains invalid character");
        }
    }

    private int getCharIndex(char c) {
        int v = (int) c;
        return v - CharMin;
    }
}
