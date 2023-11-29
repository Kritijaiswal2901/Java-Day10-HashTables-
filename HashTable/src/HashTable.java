// Represents a hash table with linked lists
public class HashTable<K, V> {
    MyMapNode<K, V>[] table;
    int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new MyMapNode[size];
    }

    // Calculates the index for a given key
    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % size);
    }

    // Adds a key-value pair to the hash table
    public void put(K key, V value) {
        int index = getIndex(key);

        if (table[index] == null) {
            table[index] = new MyMapNode<>(key, value);
        } else {
            MyMapNode<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new MyMapNode<>(key, value);
        }
    }

    // Gets the value associated with a key in the hash table
    public V get(K key) {
        int index = getIndex(key);

        MyMapNode<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    // Removes a key-value pair from the hash table based on the key
    public void remove(K key) {
        int index = getIndex(key);

        MyMapNode<K, V> current = table[index];
        MyMapNode<K, V> prev = null;

        while (current != null && !current.key.equals(key)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev != null) {
                prev.next = current.next;
            } else {
                table[index] = current.next;
            }
        }
    }
}




