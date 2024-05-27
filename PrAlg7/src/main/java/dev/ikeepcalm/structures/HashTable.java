package dev.ikeepcalm.structures;

public class HashTable {

    private Entry[] table;
    private int capacity;
    private int taken;
    private int comparisons;
    private int collisions;

    private int hash(String str) {
        int hash = 0;
        int x;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            hash = (hash << 4) + str.charAt(i);
            if ((x = hash & 0xF0000000) != 0) {
                hash ^= (x >> 3);
            }
            hash &= ~x;
        }

        return hash % this.capacity;
    }

    public HashTable() {
        this.table = new Entry[16];
        this.capacity = 16;
    }

    public void put(String key, String value) {
        if ((double) taken / capacity > 0.65) {
            resizeTable();
        }
        int index = hash(key);
        Entry newEntry = new Entry(key, value);
        Entry current = table[index];

        while (current != null) {
            comparisons++;
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            collisions++;
            if (current.next == null) {
                current.next = newEntry;
                return;
            } else {
                current = current.next;
            }
        }

        taken++;
        table[index] = newEntry;
    }

    public String get(String key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            comparisons++;
            current = current.next;
        }

        return null;
    }

    private void resizeTable() {
        int newSize = capacity * 2;
        Entry[] newTable = new Entry[newSize];
        this.capacity = newSize;
        for (Entry entry : table) {
            if (entry != null) {
                int index = hash(entry.key);
                Entry current = newTable[index];
                if (current == null) {
                    newTable[index] = entry;
                } else {
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = entry;
                }
            }
        }

        table = newTable;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getCollisions() {
        return collisions;
    }

    private static class Entry {
        String key;
        String value;
        Entry next;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : table) {
            if (entry != null) {
                sb.append(hash(entry.key)).append(" | ").append(entry.key).append(" : ").append(entry.value).append("\n");
                Entry next = entry.next;
                while (next != null) {
                    sb.append(hash(next.key)).append(" | ").append(next.key).append(" : ").append(next.value).append("\n");
                    next = next.next;
                }
            }
        }
        return sb.toString();
    }

}
