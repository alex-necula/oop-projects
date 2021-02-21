package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> {
    private final List<Entry<K, V>> entryList;
    private final int numBuckets;
    private int size;

    public MyHashMap() {
        entryList = new ArrayList<>();
        numBuckets = 20;
        size = 0;

        // Initialise entryList
        for (int i = 0; i < numBuckets; i++) {
            entryList.add(null);
        }
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % numBuckets;
    }

    public V get(K key) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = entryList.get(bucketIndex);

        // Search key in chain
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        // If key not found
        return null;
    }

    public void put(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = entryList.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key
        size++;
        head = entryList.get(bucketIndex);
        Entry<K, V> newEntry = new Entry<K, V>(key, value);
        newEntry.next = head;
        entryList.set(bucketIndex, newEntry);
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}
