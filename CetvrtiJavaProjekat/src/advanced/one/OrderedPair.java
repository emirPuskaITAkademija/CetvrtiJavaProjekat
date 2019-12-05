package advanced.one;
//K,V

public class OrderedPair<K, V> implements Pair<K, V> {

    private final K key;
    private final V value;

    public OrderedPair(K kljuc, V vrijednost) {
        this.key = kljuc;
        this.value = vrijednost;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

}
